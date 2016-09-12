package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Contains the data necessary to activate the [Dashboard SSO feature](https://docs.cloudfoundry.org/services/dashboard-sso.html) for this service
 **/
@ApiModel(description = "Contains the data necessary to activate the [Dashboard SSO feature](https://docs.cloudfoundry.org/services/dashboard-sso.html) for this service")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class DashboardClient  {
  
  private String id = null;
  private String secret = null;
  private String redirectUri = null;

  /**
   * The id of the Oauth2 client that the service intends to use. The name may be taken, in which case the API will return an error to the operator
   **/
  @ApiModelProperty(value = "The id of the Oauth2 client that the service intends to use. The name may be taken, in which case the API will return an error to the operator")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * A secret for the dashboard client
   **/
  @ApiModelProperty(value = "A secret for the dashboard client")
  @JsonProperty("secret")
  public String getSecret() {
    return secret;
  }
  public void setSecret(String secret) {
    this.secret = secret;
  }

  /**
   * A domain for the service dashboard that will be whitelisted by the UAA to enable SSO
   **/
  @ApiModelProperty(value = "A domain for the service dashboard that will be whitelisted by the UAA to enable SSO")
  @JsonProperty("redirect_uri")
  public String getRedirectUri() {
    return redirectUri;
  }
  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardClient dashboardClient = (DashboardClient) o;
    return Objects.equals(id, dashboardClient.id) &&
        Objects.equals(secret, dashboardClient.secret) &&
        Objects.equals(redirectUri, dashboardClient.redirectUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, secret, redirectUri);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardClient {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  secret: ").append(secret).append("\n");
    sb.append("  redirectUri: ").append(redirectUri).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
