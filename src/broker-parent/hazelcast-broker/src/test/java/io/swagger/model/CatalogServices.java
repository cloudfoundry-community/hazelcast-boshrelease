package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Services;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * list of services
 **/
@ApiModel(description = "list of services")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class CatalogServices  {
  
  private List<Services> services = new ArrayList<Services>();

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("services")
  public List<Services> getServices() {
    return services;
  }
  public void setServices(List<Services> services) {
    this.services = services;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CatalogServices catalogServices = (CatalogServices) o;
    return Objects.equals(services, catalogServices.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogServices {\n");
    
    sb.append("  services: ").append(services).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
