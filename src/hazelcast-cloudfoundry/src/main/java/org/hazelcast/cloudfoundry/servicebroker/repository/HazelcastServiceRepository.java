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


package org.hazelcast.cloudfoundry.servicebroker.repository;

import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HazelcastServiceRepository {

    private static final HazelcastServiceRepository instance = new HazelcastServiceRepository();
    private Map<String, ServiceInstance> serviceInstanceRepository;
    private Map<String, ServiceInstanceBinding> serviceInstanceBindingRepository;

    private HazelcastServiceRepository() {
        serviceInstanceRepository = new HashMap<String, ServiceInstance>();
        serviceInstanceBindingRepository = new HashMap<String, ServiceInstanceBinding>();
    }

    public static HazelcastServiceRepository getInstance() {
        return instance;
    }

    public ServiceInstance findServiceInstance(String id) {
        return serviceInstanceRepository.get(id);
    }

    public void saveServiceInstance(ServiceInstance serviceInstance) {
        serviceInstanceRepository.put(serviceInstance.getServiceInstanceId(), serviceInstance);
    }

    public boolean exists(ServiceInstance serviceInstance) {
        return serviceInstanceRepository.containsKey(serviceInstance.getServiceInstanceId());
    }

    public void deleteServiceInstance(ServiceInstance serviceInstance) {
        serviceInstanceRepository.remove(serviceInstance.getServiceInstanceId());
    }

    public ServiceInstanceBinding findServiceInstanceBinding(String id) {
        return serviceInstanceBindingRepository.get(id);
    }

    public void saveServiceInstanceBinding(ServiceInstanceBinding serviceInstanceBinding) {
        serviceInstanceBindingRepository.put(serviceInstanceBinding.getId(), serviceInstanceBinding);
    }

    public void deleteServiceInstanceBinding(ServiceInstanceBinding serviceInstanceBinding) {
        if(serviceInstanceBinding != null)
            serviceInstanceBindingRepository.remove(serviceInstanceBinding.getId());
    }

    public Collection<ServiceInstance> getAllServiceInstances() {
        return serviceInstanceRepository.values();
    }

}
