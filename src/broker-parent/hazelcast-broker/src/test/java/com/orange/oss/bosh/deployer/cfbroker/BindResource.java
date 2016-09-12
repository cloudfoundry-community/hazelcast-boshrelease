package com.orange.oss.bosh.deployer.cfbroker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BindResource {

	  private String appGuid = null;

    @JsonProperty("app_guid")
	public String getAppGuid() {
		return appGuid;
	}

	public void setAppGuid(String appGuid) {
		this.appGuid = appGuid;
	}
}
