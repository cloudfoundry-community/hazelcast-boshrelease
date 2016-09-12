package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Parameter;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Information to bind the service to an application.
 **/
@ApiModel(description = "Information to bind the service to an application.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class Binding  {
  
  private String appGuid = null;
  private String planId = null;
  private String serviceId = null;
  private Parameter parameters = null;

  /**
   * GUID of the application that you want to bind your service to. Will be included when users bind applications to service instances.
   **/
  @ApiModelProperty(value = "GUID of the application that you want to bind your service to. Will be included when users bind applications to service instances.")
  @JsonProperty("app_guid")
  public String getAppGuid() {
    return appGuid;
  }
  public void setAppGuid(String appGuid) {
    this.appGuid = appGuid;
  }

  /**
   * ID of the plan from the catalog. While not strictly necessary, some brokers might make use of this ID.
   **/
  @ApiModelProperty(value = "ID of the plan from the catalog. While not strictly necessary, some brokers might make use of this ID.")
  @JsonProperty("plan_id")
  public String getPlanId() {
    return planId;
  }
  public void setPlanId(String planId) {
    this.planId = planId;
  }

  /**
   * ID of the service from the catalog. While not strictly necessary, some brokers might make use of this ID.
   **/
  @ApiModelProperty(value = "ID of the service from the catalog. While not strictly necessary, some brokers might make use of this ID.")
  @JsonProperty("service_id")
  public String getServiceId() {
    return serviceId;
  }
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  /**
   * Cloud Foundry API clients can provide a JSON object of configuration parameters with their request and this value will be passed through to the service broker. Brokers are responsible for validation.
   **/
  @ApiModelProperty(value = "Cloud Foundry API clients can provide a JSON object of configuration parameters with their request and this value will be passed through to the service broker. Brokers are responsible for validation.")
  @JsonProperty("parameters")
  public Parameter getParameters() {
    return parameters;
  }
  public void setParameters(Parameter parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Binding binding = (Binding) o;
    return Objects.equals(appGuid, binding.appGuid) &&
        Objects.equals(planId, binding.planId) &&
        Objects.equals(serviceId, binding.serviceId) &&
        Objects.equals(parameters, binding.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appGuid, planId, serviceId, parameters);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Binding {\n");
    
    sb.append("  appGuid: ").append(appGuid).append("\n");
    sb.append("  planId: ").append(planId).append("\n");
    sb.append("  serviceId: ").append(serviceId).append("\n");
    sb.append("  parameters: ").append(parameters).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
