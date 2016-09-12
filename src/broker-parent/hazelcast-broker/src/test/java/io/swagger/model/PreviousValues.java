package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Information about the instance prior to the update.
 **/
@ApiModel(description = "Information about the instance prior to the update.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class PreviousValues  {
  
  private String planId = null;
  private String serviceId = null;
  private String organizationId = null;
  private String spaceId = null;

  /**
   * ID of the plan prior to the update.
   **/
  @ApiModelProperty(value = "ID of the plan prior to the update.")
  @JsonProperty("plan_id")
  public String getPlanId() {
    return planId;
  }
  public void setPlanId(String planId) {
    this.planId = planId;
  }

  /**
   * ID of the service for the instance.
   **/
  @ApiModelProperty(value = "ID of the service for the instance.")
  @JsonProperty("service_id")
  public String getServiceId() {
    return serviceId;
  }
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  /**
   * ID of the organization containing the instance.
   **/
  @ApiModelProperty(value = "ID of the organization containing the instance.")
  @JsonProperty("organization_id")
  public String getOrganizationId() {
    return organizationId;
  }
  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  /**
   * ID of the space containing the instance.
   **/
  @ApiModelProperty(value = "ID of the space containing the instance.")
  @JsonProperty("space_id")
  public String getSpaceId() {
    return spaceId;
  }
  public void setSpaceId(String spaceId) {
    this.spaceId = spaceId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreviousValues previousValues = (PreviousValues) o;
    return Objects.equals(planId, previousValues.planId) &&
        Objects.equals(serviceId, previousValues.serviceId) &&
        Objects.equals(organizationId, previousValues.organizationId) &&
        Objects.equals(spaceId, previousValues.spaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, serviceId, organizationId, spaceId);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviousValues {\n");
    
    sb.append("  planId: ").append(planId).append("\n");
    sb.append("  serviceId: ").append(serviceId).append("\n");
    sb.append("  organizationId: ").append(organizationId).append("\n");
    sb.append("  spaceId: ").append(spaceId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
