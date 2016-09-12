package com.orange.oss.bosh.deployer.cfbroker;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.Binding;

public class Binding28 extends Binding {

	private BindResource bindResource;

	@JsonProperty("bind_resource")
	public BindResource getBindResource() {
		return bindResource;
	}

	public void setBindResource(BindResource bindResource) {
		this.bindResource = bindResource;
	} 
	
}
