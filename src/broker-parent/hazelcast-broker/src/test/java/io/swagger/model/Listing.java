package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Listing.
 **/
@ApiModel(description = "Listing.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
public class Listing  {
  
  private String blurb = null;
  private String imageUrl = null;
  private String longDescription = null;

  /**
   * blurb
   **/
  @ApiModelProperty(value = "blurb")
  @JsonProperty("blurb")
  public String getBlurb() {
    return blurb;
  }
  public void setBlurb(String blurb) {
    this.blurb = blurb;
  }

  /**
   * image URL.
   **/
  @ApiModelProperty(value = "image URL.")
  @JsonProperty("imageUrl")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   * Long Description
   **/
  @ApiModelProperty(value = "Long Description")
  @JsonProperty("longDescription")
  public String getLongDescription() {
    return longDescription;
  }
  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Listing listing = (Listing) o;
    return Objects.equals(blurb, listing.blurb) &&
        Objects.equals(imageUrl, listing.imageUrl) &&
        Objects.equals(longDescription, listing.longDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blurb, imageUrl, longDescription);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Listing {\n");
    
    sb.append("  blurb: ").append(blurb).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  longDescription: ").append(longDescription).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
