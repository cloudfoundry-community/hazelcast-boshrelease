package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Parameter;
import io.swagger.model.PreviousValues;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * New Plan to be added to a service.
 **/
@ApiModel(description = "New Plan to be added to a service.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class ServicePlan  {
  
  private String planId = null;
  private Parameter parameters = null;
  private PreviousValues previousValues = null;

  /**
   * ID of the new plan from the catalog.
   **/
  @ApiModelProperty(value = "ID of the new plan from the catalog.")
  @JsonProperty("plan_id")
  public String getPlanId() {
    return planId;
  }
  public void setPlanId(String planId) {
    this.planId = planId;
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

  /**
   * Information about the instance prior to the update.
   **/
  @ApiModelProperty(value = "Information about the instance prior to the update.")
  @JsonProperty("previous_values")
  public PreviousValues getPreviousValues() {
    return previousValues;
  }
  public void setPreviousValues(PreviousValues previousValues) {
    this.previousValues = previousValues;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicePlan servicePlan = (ServicePlan) o;
    return Objects.equals(planId, servicePlan.planId) &&
        Objects.equals(parameters, servicePlan.parameters) &&
        Objects.equals(previousValues, servicePlan.previousValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, parameters, previousValues);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServicePlan {\n");
    
    sb.append("  planId: ").append(planId).append("\n");
    sb.append("  parameters: ").append(parameters).append("\n");
    sb.append("  previousValues: ").append(previousValues).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
