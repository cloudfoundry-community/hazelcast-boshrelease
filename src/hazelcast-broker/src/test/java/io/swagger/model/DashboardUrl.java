package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * The URL of a web-based management user interface for the service instance; we refer to this as a service dashboard. The URL should contain enough information for the dashboard to identify the resource being accessed ( in the example below). For information on how users can authenticate with service dashboards via SSO, [see Dashboard Single Sign-On](https://docs.cloudfoundry.org/services/dashboard-sso.html).
 **/
@ApiModel(description = "The URL of a web-based management user interface for the service instance; we refer to this as a service dashboard. The URL should contain enough information for the dashboard to identify the resource being accessed ( in the example below). For information on how users can authenticate with service dashboards via SSO, [see Dashboard Single Sign-On](https://docs.cloudfoundry.org/services/dashboard-sso.html).")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class DashboardUrl  {
  
  private String dashboardUrl = null;

  /**
   * The URL of a web-based management user interface for the service instance; we refer to this as a service dashboard. The URL should contain enough information for the dashboard to identify the resource being accessed (in the example below). For information on how users can authenticate with service dashboards via SSO, [see Dashboard Single Sign-On](https://docs.cloudfoundry.org/services/dashboard-sso.html).
   **/
  @ApiModelProperty(value = "The URL of a web-based management user interface for the service instance; we refer to this as a service dashboard. The URL should contain enough information for the dashboard to identify the resource being accessed (in the example below). For information on how users can authenticate with service dashboards via SSO, [see Dashboard Single Sign-On](https://docs.cloudfoundry.org/services/dashboard-sso.html).")
  @JsonProperty("dashboard_url")
  public String getDashboardUrl() {
    return dashboardUrl;
  }
  public void setDashboardUrl(String dashboardUrl) {
    this.dashboardUrl = dashboardUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardUrl dashboardUrl = (DashboardUrl) o;
    return Objects.equals(dashboardUrl, dashboardUrl.dashboardUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dashboardUrl);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardUrl {\n");
    
    sb.append("  dashboardUrl: ").append(dashboardUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
