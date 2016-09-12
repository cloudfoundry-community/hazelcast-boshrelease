package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * A plan for the service
 **/
@ApiModel(description = "A plan for the service")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class Plan  {
  
  private String id = null;
  private String name = null;
  private String description = null;
  private Object metadata = null;
  private Boolean free = null;

  /**
   * An identifier used to correlate this plan in future requests to the catalog. This must be unique within Cloud Foundry, using a GUID is recommended.
   **/
  @ApiModelProperty(value = "An identifier used to correlate this plan in future requests to the catalog. This must be unique within Cloud Foundry, using a GUID is recommended.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The CLI-friendly name of the plan that will appear in the catalog. All lowercase, no spaces.
   **/
  @ApiModelProperty(value = "The CLI-friendly name of the plan that will appear in the catalog. All lowercase, no spaces.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * A short description of the service that will appear in the catalog.
   **/
  @ApiModelProperty(value = "A short description of the service that will appear in the catalog.")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * A list of metadata for a service plan. For more information, [see Service Metadata](https://docs.cloudfoundry.org/services/catalog-metadata.html).
   **/
  @ApiModelProperty(value = "A list of metadata for a service plan. For more information, [see Service Metadata](https://docs.cloudfoundry.org/services/catalog-metadata.html).")
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   * This field allows the plan to be limited by the non_basic_services_allowed field in a Cloud Foundry Quota, [see Quota Plans](http://docs.cloudfoundry.org/running/managing-cf/quota-plans.html).
   **/
  @ApiModelProperty(value = "This field allows the plan to be limited by the non_basic_services_allowed field in a Cloud Foundry Quota, [see Quota Plans](http://docs.cloudfoundry.org/running/managing-cf/quota-plans.html).")
  @JsonProperty("free")
  public Boolean getFree() {
    return free;
  }
  public void setFree(Boolean free) {
    this.free = free;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Plan plan = (Plan) o;
    return Objects.equals(id, plan.id) &&
        Objects.equals(name, plan.name) &&
        Objects.equals(description, plan.description) &&
        Objects.equals(metadata, plan.metadata) &&
        Objects.equals(free, plan.free);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, metadata, free);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plan {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("  free: ").append(free).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
