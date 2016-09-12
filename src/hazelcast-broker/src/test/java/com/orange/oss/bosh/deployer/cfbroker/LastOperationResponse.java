package com.orange.oss.bosh.deployer.cfbroker;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * response to last_operation request
 **/
@ApiModel(description = "last operation response")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class LastOperationResponse {

	private String state;
	private String description = null;

	// @ApiModelProperty(value = "The URL of a web-based management user
	// interface for the service instance; we refer to this as a service
	// dashboard. The URL should contain enough information for the dashboard to
	// identify the resource being accessed (in the example below). For
	// information on how users can authenticate with service dashboards via
	// SSO, [see Dashboard Single
	// Sign-On](https://docs.cloudfoundry.org/services/dashboard-sso.html).")
	@JsonProperty("state")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// @ApiModelProperty(value = "The URL of a web-based management user
	// interface for the service instance; we refer to this as a service
	// dashboard. The URL should contain enough information for the dashboard to
	// identify the resource being accessed (in the example below). For
	// information on how users can authenticate with service dashboards via
	// SSO, [see Dashboard Single
	// Sign-On](https://docs.cloudfoundry.org/services/dashboard-sso.html).")
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LastOperationResponse lop = (LastOperationResponse) o;
		return Objects.equals(state, lop.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(state);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Last Operation Respone {\n");

		sb.append("  state: ").append(state).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
