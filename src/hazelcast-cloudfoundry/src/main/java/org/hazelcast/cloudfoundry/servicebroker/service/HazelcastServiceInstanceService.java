/*
 * Copyright (c) 2008-2015, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.hazelcast.cloudfoundry.servicebroker.service;

import com.hazelcast.core.HazelcastInstance;
import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceDoesNotExistException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceExistsException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceUpdateNotSupportedException;
import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.DeleteServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.UpdateServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceService;
import org.hazelcast.cloudfoundry.servicebroker.exception.HazelcastServiceException;
import org.hazelcast.cloudfoundry.servicebroker.repository.HazelcastServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class HazelcastServiceInstanceService implements ServiceInstanceService {

    private static HazelcastServiceRepository repository = HazelcastServiceRepository.getInstance();
    private HazelcastAdmin hazelcastAdmin;

    @Autowired
    public HazelcastServiceInstanceService(HazelcastAdmin hazelcastAdmin) {
        this.hazelcastAdmin = hazelcastAdmin;
    }

    @Override
    public ServiceInstance createServiceInstance(CreateServiceInstanceRequest createServiceInstanceRequest) throws ServiceInstanceExistsException, ServiceBrokerException {

        String instanceId = createServiceInstanceRequest.getServiceInstanceId();

        ServiceInstance serviceInstance = repository.findServiceInstance(instanceId);
        if(serviceInstance != null) {
            throw new ServiceInstanceExistsException(serviceInstance);
        }

        serviceInstance = new HazelcastServiceInstance(createServiceInstanceRequest);

        HazelcastInstance hazelcastInstance = hazelcastAdmin.createHazelcastInstance(createServiceInstanceRequest.getServiceInstanceId());
        if(hazelcastInstance == null) {
            throw new HazelcastServiceException("Failed to create new Hazelcast member hazelcastInstance: "+createServiceInstanceRequest.getServiceInstanceId());
        }

        String hazelcastHost = hazelcastInstance.getCluster().getLocalMember().getAddress().getHost();
        ((HazelcastServiceInstance) serviceInstance).setHazelcastIPAddress(hazelcastHost);

        int hazelcastPort = hazelcastInstance.getCluster().getLocalMember().getAddress().getPort();
        ((HazelcastServiceInstance) serviceInstance).setHazelcastPort(hazelcastPort);

        try {
            InetAddress hazelcastInetAddress = hazelcastInstance.getCluster().getLocalMember().getAddress().getInetAddress();
            ((HazelcastServiceInstance) serviceInstance).setHazelcastInetAddress(hazelcastInetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        repository.saveServiceInstance(serviceInstance);
        return serviceInstance;
    }

    @Override
    public ServiceInstance getServiceInstance(String s) {
        return repository.findServiceInstance(s);
    }

    @Override
    public ServiceInstance deleteServiceInstance(DeleteServiceInstanceRequest deleteServiceInstanceRequest) throws ServiceBrokerException {
        ServiceInstance serviceInstance = repository.findServiceInstance(deleteServiceInstanceRequest.getServiceInstanceId());
        if(serviceInstance != null) {
            repository.deleteServiceInstance(serviceInstance);
            hazelcastAdmin.deleteHazelcastInstance(deleteServiceInstanceRequest.getServiceInstanceId());
        }
        return serviceInstance;
    }

    @Override
    public ServiceInstance updateServiceInstance(UpdateServiceInstanceRequest updateServiceInstanceRequest) throws ServiceInstanceUpdateNotSupportedException, ServiceBrokerException, ServiceInstanceDoesNotExistException {
        ServiceInstance serviceInstance = repository.findServiceInstance(updateServiceInstanceRequest.getServiceInstanceId());
        if(serviceInstance == null) {
            throw new ServiceInstanceDoesNotExistException(updateServiceInstanceRequest.getServiceInstanceId());
        }
        repository.deleteServiceInstance(serviceInstance);

        ServiceInstance updatedServiceInstance = new ServiceInstance(updateServiceInstanceRequest);
        repository.saveServiceInstance(updatedServiceInstance);
        return updatedServiceInstance;
    }
}
