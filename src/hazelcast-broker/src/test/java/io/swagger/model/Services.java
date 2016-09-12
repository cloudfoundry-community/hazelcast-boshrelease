package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DashboardClient;
import io.swagger.model.MetaData;
import io.swagger.model.Plan;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Schema of a service object
 **/
@ApiModel(description = "Schema of a service object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class Services  {
  
  private String id = null;
  private String name = null;
  private String description = null;
  private Boolean bindable = null;
  private List<String> tags = new ArrayList<String>();
  private MetaData metadata = null;
  private List<String> requires = new ArrayList<String>();
  private Boolean planUpdateable = null;
  private List<Plan> plans = new ArrayList<Plan>();
  private DashboardClient dashboardClient = null;

  /**
   * An identifier used to correlate this service in future requests to the catalog. This must be unique within Cloud Foundry, using a GUID is recommended. 
   **/
  @ApiModelProperty(value = "An identifier used to correlate this service in future requests to the catalog. This must be unique within Cloud Foundry, using a GUID is recommended. ")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The CLI-friendly name of the service that will appear in the catalog. All lowercase, no spaces.
   **/
  @ApiModelProperty(value = "The CLI-friendly name of the service that will appear in the catalog. All lowercase, no spaces.")
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
   * Whether the service can be bound to applications.
   **/
  @ApiModelProperty(value = "Whether the service can be bound to applications.")
  @JsonProperty("bindable")
  public Boolean getBindable() {
    return bindable;
  }
  public void setBindable(Boolean bindable) {
    this.bindable = bindable;
  }

  /**
   * Tags provide a flexible mechanism to expose a classification, attribute, or base technology of a service, enabling equivalent services to be swapped out without changes to dependent logic in applications, buildpacks, or other services. E.g. mysql, relational, redis, key-value, caching, messaging, amqp. 
   **/
  @ApiModelProperty(value = "Tags provide a flexible mechanism to expose a classification, attribute, or base technology of a service, enabling equivalent services to be swapped out without changes to dependent logic in applications, buildpacks, or other services. E.g. mysql, relational, redis, key-value, caching, messaging, amqp. ")
  @JsonProperty("tags")
  public List<String> getTags() {
    return tags;
  }
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * A list of metadata for a service offering. For more information, see [Service Metadata](https://docs.cloudfoundry.org/services/catalog-metadata.html).
   **/
  @ApiModelProperty(value = "A list of metadata for a service offering. For more information, see [Service Metadata](https://docs.cloudfoundry.org/services/catalog-metadata.html).")
  @JsonProperty("metadata")
  public MetaData getMetadata() {
    return metadata;
  }
  public void setMetadata(MetaData metadata) {
    this.metadata = metadata;
  }

  /**
   * A list of permissions that the user would have to give the service, if they provision it. The only permission currently supported is syslog_drain; for more info [see Application Log Streaming](https://docs.cloudfoundry.org/services/app-log-streaming.html).
   **/
  @ApiModelProperty(value = "A list of permissions that the user would have to give the service, if they provision it. The only permission currently supported is syslog_drain; for more info [see Application Log Streaming](https://docs.cloudfoundry.org/services/app-log-streaming.html).")
  @JsonProperty("requires")
  public List<String> getRequires() {
    return requires;
  }
  public void setRequires(List<String> requires) {
    this.requires = requires;
  }

  /**
   * Whether the service supports upgrade/downgrade for some plans. Please note that the misspelling of the attribute plan_updatable to plan_updateable was done by mistake. We have opted to keep that misspelling instead of fixing it and thus breaking backward compatibility.
   **/
  @ApiModelProperty(value = "Whether the service supports upgrade/downgrade for some plans. Please note that the misspelling of the attribute plan_updatable to plan_updateable was done by mistake. We have opted to keep that misspelling instead of fixing it and thus breaking backward compatibility.")
  @JsonProperty("plan_updateable")
  public Boolean getPlanUpdateable() {
    return planUpdateable;
  }
  public void setPlanUpdateable(Boolean planUpdateable) {
    this.planUpdateable = planUpdateable;
  }

  /**
   * A list of plans for this service
   **/
  @ApiModelProperty(value = "A list of plans for this service")
  @JsonProperty("plans")
  public List<Plan> getPlans() {
    return plans;
  }
  public void setPlans(List<Plan> plans) {
    this.plans = plans;
  }

  /**
   * Contains the data necessary to activate the [Dashboard SSO feature](https://docs.cloudfoundry.org/services/dashboard-sso.html) for this service
   **/
  @ApiModelProperty(value = "Contains the data necessary to activate the [Dashboard SSO feature](https://docs.cloudfoundry.org/services/dashboard-sso.html) for this service")
  @JsonProperty("dashboard_client")
  public DashboardClient getDashboardClient() {
    return dashboardClient;
  }
  public void setDashboardClient(DashboardClient dashboardClient) {
    this.dashboardClient = dashboardClient;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Services services = (Services) o;
    return Objects.equals(id, services.id) &&
        Objects.equals(name, services.name) &&
        Objects.equals(description, services.description) &&
        Objects.equals(bindable, services.bindable) &&
        Objects.equals(tags, services.tags) &&
        Objects.equals(metadata, services.metadata) &&
        Objects.equals(requires, services.requires) &&
        Objects.equals(planUpdateable, services.planUpdateable) &&
        Objects.equals(plans, services.plans) &&
        Objects.equals(dashboardClient, services.dashboardClient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, bindable, tags, metadata, requires, planUpdateable, plans, dashboardClient);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Services {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  bindable: ").append(bindable).append("\n");
    sb.append("  tags: ").append(tags).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("  requires: ").append(requires).append("\n");
    sb.append("  planUpdateable: ").append(planUpdateable).append("\n");
    sb.append("  plans: ").append(plans).append("\n");
    sb.append("  dashboardClient: ").append(dashboardClient).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
