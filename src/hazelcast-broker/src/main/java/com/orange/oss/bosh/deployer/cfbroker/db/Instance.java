package com.orange.oss.bosh.deployer.cfbroker.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instance {

	@Id
	private String serviceInstanceId;
	
	private String deployment;
	
	//generic deployment Spec
	private String deploymentSpec;
	
	//generated bosh deployment manifest 
	private String deploymentManifest;
	
	
	
	public String getDeploymentSpec() {
		return deploymentSpec;
	}

	public void setDeploymentSpec(String deploymentSpec) {
		this.deploymentSpec = deploymentSpec;
	}

	public String getDeploymentManifest() {
		return deploymentManifest;
	}

	public void setDeploymentManifest(String deploymentManifest) {
		this.deploymentManifest = deploymentManifest;
	}

	public String getDeployment() {
		return deployment;
	}

	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}


	private Integer lastTaskId;

	public Integer getLastTaskId() {
		return lastTaskId;
	}

	public void setLastTaskId(Integer lastTaskId) {
		this.lastTaskId = lastTaskId;
	}

	protected Instance(){
	}
	
	public Instance(String id){
		this.serviceInstanceId=id;
	}
	
	
	public String getServiceInstanceId() {
		return serviceInstanceId;
	}

	
}
