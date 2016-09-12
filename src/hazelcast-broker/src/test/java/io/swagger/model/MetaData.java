package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Listing;
import io.swagger.model.Provider;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * metadata related to the service
 **/
@ApiModel(description = "metadata related to the service")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class MetaData  {
  
  private String displayName = null;
  private Listing listing = null;
  private Provider provider = null;

  /**
   * displayName of the service.
   **/
  @ApiModelProperty(value = "displayName of the service.")
  @JsonProperty("displayName")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * Listing.
   **/
  @ApiModelProperty(value = "Listing.")
  @JsonProperty("listing")
  public Listing getListing() {
    return listing;
  }
  public void setListing(Listing listing) {
    this.listing = listing;
  }

  /**
   * Provider of the service.
   **/
  @ApiModelProperty(value = "Provider of the service.")
  @JsonProperty("provider")
  public Provider getProvider() {
    return provider;
  }
  public void setProvider(Provider provider) {
    this.provider = provider;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaData metaData = (MetaData) o;
    return Objects.equals(displayName, metaData.displayName) &&
        Objects.equals(listing, metaData.listing) &&
        Objects.equals(provider, metaData.provider);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, listing, provider);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaData {\n");
    
    sb.append("  displayName: ").append(displayName).append("\n");
    sb.append("  listing: ").append(listing).append("\n");
    sb.append("  provider: ").append(provider).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
