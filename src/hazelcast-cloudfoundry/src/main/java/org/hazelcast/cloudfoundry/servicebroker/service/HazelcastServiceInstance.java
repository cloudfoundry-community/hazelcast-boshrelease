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

import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;

import java.net.InetAddress;

public class HazelcastServiceInstance extends ServiceInstance {

    private String hazelcastIPAddress;
    private InetAddress hazelcastInetAddress;
    private int hazelcastPort;

    public HazelcastServiceInstance(CreateServiceInstanceRequest request) {
        super(request);
    }

    public String getHazelcastIPAddress() {
        return hazelcastIPAddress;
    }

    public void setHazelcastIPAddress(String ipAddress) {
        this.hazelcastIPAddress = ipAddress;
    }

    public InetAddress getHazelcastInetAddress() {
        return hazelcastInetAddress;
    }

    public void setHazelcastInetAddress(InetAddress hazelcastInetAddress) {
        this.hazelcastInetAddress = hazelcastInetAddress;
    }

    public int getHazelcastPort() {
        return hazelcastPort;
    }

    public void setHazelcastPort(int hazelcastPort) {
        this.hazelcastPort = hazelcastPort;
    }
}
