package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Success binding response.
 **/
@ApiModel(description = "Success binding response.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class BindingResponse  {
  
  private Object credentials = null;
  private String syslogDrainUrl = null;

  /**
   * A free-form hash of credentials that the bound application can use to access the service. For more information, [see Binding Credentials](https://docs.cloudfoundry.org/services/binding-credentials.html).
   **/
  @ApiModelProperty(value = "A free-form hash of credentials that the bound application can use to access the service. For more information, [see Binding Credentials](https://docs.cloudfoundry.org/services/binding-credentials.html).")
  @JsonProperty("credentials")
  public Object getCredentials() {
    return credentials;
  }
  public void setCredentials(Object credentials) {
    this.credentials = credentials;
  }

  /**
   * A URL to which Cloud Foundry should drain logs for the bound application. requires syslog_drain must be declared in the catalog endpoint or Cloud Foundry will consider the response invalid. For details, [see Application Log Streaming](https://docs.cloudfoundry.org/services/app-log-streaming.html).
   **/
  @ApiModelProperty(value = "A URL to which Cloud Foundry should drain logs for the bound application. requires syslog_drain must be declared in the catalog endpoint or Cloud Foundry will consider the response invalid. For details, [see Application Log Streaming](https://docs.cloudfoundry.org/services/app-log-streaming.html).")
  @JsonProperty("syslog_drain_url")
  public String getSyslogDrainUrl() {
    return syslogDrainUrl;
  }
  public void setSyslogDrainUrl(String syslogDrainUrl) {
    this.syslogDrainUrl = syslogDrainUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BindingResponse bindingResponse = (BindingResponse) o;
    return Objects.equals(credentials, bindingResponse.credentials) &&
        Objects.equals(syslogDrainUrl, bindingResponse.syslogDrainUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credentials, syslogDrainUrl);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BindingResponse {\n");
    
    sb.append("  credentials: ").append(credentials).append("\n");
    sb.append("  syslogDrainUrl: ").append(syslogDrainUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
