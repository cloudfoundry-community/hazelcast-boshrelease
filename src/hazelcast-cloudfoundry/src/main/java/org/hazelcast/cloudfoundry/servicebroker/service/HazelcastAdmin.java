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

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.hazelcast.cloudfoundry.servicebroker.repository.HazelcastServiceRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HazelcastAdmin {

    private static HazelcastServiceRepository repository = HazelcastServiceRepository.getInstance();
    private Map<String, HazelcastInstance> hazelcastInstances;


    public HazelcastAdmin() {
        hazelcastInstances = new HashMap<String, HazelcastInstance>();
    }

    public HazelcastInstance createHazelcastInstance(String instanceId) {
        Config config = getHazelcastInstanceConfig(instanceId);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        hazelcastInstances.put(instanceId, instance);
        return instance;
    }

    private String getClusterMembersConfig() {
        StringBuilder clusterMembersConfigBuilder = null;

        if(repository.getAllServiceInstances().size() > 0) {
            clusterMembersConfigBuilder = new StringBuilder();
            for (ServiceInstance serviceInstance : repository.getAllServiceInstances()) {
                clusterMembersConfigBuilder.append(((HazelcastServiceInstance) serviceInstance).getHazelcastIPAddress());
                clusterMembersConfigBuilder.append(",");
            }
            clusterMembersConfigBuilder.deleteCharAt(clusterMembersConfigBuilder.length() - 1);
        }

        return clusterMembersConfigBuilder == null ? null : clusterMembersConfigBuilder.toString();
    }

    private Config getHazelcastInstanceConfig(String serviceInstanceId) {
        Config config = new Config();
        String managementCenterURL = System.getenv("MANAGEMENT_CENTER_URL");
        if(managementCenterURL != null && !managementCenterURL.equals("")) {
            config.getManagementCenterConfig().setEnabled(true)
                    .setUrl(managementCenterURL).setUpdateInterval(3);
        }
        config.setInstanceName(serviceInstanceId);
        NetworkConfig network = config.getNetworkConfig();
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getTcpIpConfig().setEnabled(true);
        String clusterMembers = getClusterMembersConfig();
        if(clusterMembers != null)
            join.getTcpIpConfig().addMember(clusterMembers);
        network.getInterfaces().setEnabled(true).addInterface("10.*.*.*");

        return config;
    }

    public void deleteHazelcastInstance(String serviceInstanceId) {
        HazelcastInstance instance = hazelcastInstances.remove(serviceInstanceId);
        instance.getLifecycleService().shutdown();
    }
}
