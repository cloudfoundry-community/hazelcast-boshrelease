package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Parameters needed to unbind a service instance
 **/
@ApiModel(description = "Parameters needed to unbind a service instance")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class UnbindParameters  {
  
  private String serviceId = null;
  private String planId = null;

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnbindParameters unbindParameters = (UnbindParameters) o;
    return Objects.equals(serviceId, unbindParameters.serviceId) &&
        Objects.equals(planId, unbindParameters.planId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, planId);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnbindParameters {\n");
    
    sb.append("  serviceId: ").append(serviceId).append("\n");
    sb.append("  planId: ").append(planId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
