package com.orange.oss.bosh.deployer.cfbroker.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstanceBinding {

	@Id
	private String serviceInstanceBindingId;
	
	private String serviceInstanceId;

	protected InstanceBinding(){
	}

	
	public InstanceBinding(String bindingId,String serviceInstanceId){
		this.serviceInstanceBindingId=bindingId;
		this.serviceInstanceId=serviceInstanceId;
	}
	
	
	public String getServiceInstanceId() {
		return serviceInstanceId;
	}


	public String getServiceInstanceBindingId() {
		return serviceInstanceBindingId;
	}

}
