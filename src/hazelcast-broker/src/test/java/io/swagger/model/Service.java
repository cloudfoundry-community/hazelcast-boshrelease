package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Parameter;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Service object
 **/
@ApiModel(description = "Service object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class Service  {
  
  private String serviceId = null;
  private String planId = null;
  private String organizationGuid = null;
  private String spaceGuid = null;
  private Parameter parameteres = null;

  /**
   * The ID of the service within the catalog above. While not strictly necessary, some brokers might make use of this ID.
   **/
  @ApiModelProperty(value = "The ID of the service within the catalog above. While not strictly necessary, some brokers might make use of this ID.")
  @JsonProperty("service_id")
  public String getServiceId() {
    return serviceId;
  }
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  /**
   * The ID of the plan within the above service (from the catalog endpoint) that the user would like provisioned. Because plans have identifiers unique to a broker, this is enough information to determine what to provision.
   **/
  @ApiModelProperty(value = "The ID of the plan within the above service (from the catalog endpoint) that the user would like provisioned. Because plans have identifiers unique to a broker, this is enough information to determine what to provision.")
  @JsonProperty("plan_id")
  public String getPlanId() {
    return planId;
  }
  public void setPlanId(String planId) {
    this.planId = planId;
  }

  /**
   * The Cloud Controller GUID of the organization under which the service is to be provisioned. Although most brokers will not use this field, it could be helpful in determining data placement or applying custom business rules.
   **/
  @ApiModelProperty(value = "The Cloud Controller GUID of the organization under which the service is to be provisioned. Although most brokers will not use this field, it could be helpful in determining data placement or applying custom business rules.")
  @JsonProperty("organization_guid")
  public String getOrganizationGuid() {
    return organizationGuid;
  }
  public void setOrganizationGuid(String organizationGuid) {
    this.organizationGuid = organizationGuid;
  }

  /**
   * Similar to organization_guid, but for the space.
   **/
  @ApiModelProperty(value = "Similar to organization_guid, but for the space.")
  @JsonProperty("space_guid")
  public String getSpaceGuid() {
    return spaceGuid;
  }
  public void setSpaceGuid(String spaceGuid) {
    this.spaceGuid = spaceGuid;
  }

  /**
   * Cloud Foundry API clients can provide a JSON object of configuration parameters with their request and this value will be passed through to the service broker. Brokers are responsible for validation.
   **/
  @ApiModelProperty(value = "Cloud Foundry API clients can provide a JSON object of configuration parameters with their request and this value will be passed through to the service broker. Brokers are responsible for validation.")
  @JsonProperty("parameteres")
  public Parameter getParameteres() {
    return parameteres;
  }
  public void setParameteres(Parameter parameteres) {
    this.parameteres = parameteres;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Service service = (Service) o;
    return Objects.equals(serviceId, service.serviceId) &&
        Objects.equals(planId, service.planId) &&
        Objects.equals(organizationGuid, service.organizationGuid) &&
        Objects.equals(spaceGuid, service.spaceGuid) &&
        Objects.equals(parameteres, service.parameteres);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, planId, organizationGuid, spaceGuid, parameteres);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Service {\n");
    
    sb.append("  serviceId: ").append(serviceId).append("\n");
    sb.append("  planId: ").append(planId).append("\n");
    sb.append("  organizationGuid: ").append(organizationGuid).append("\n");
    sb.append("  spaceGuid: ").append(spaceGuid).append("\n");
    sb.append("  parameteres: ").append(parameteres).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
