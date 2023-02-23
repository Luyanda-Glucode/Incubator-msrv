/*
 * Swagger Weather App
 * This is a simple weather app with swagger
 *
 * OpenAPI spec version: 1.0.6
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * WeatherModel
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-02-23T10:01:27.507+02:00")
public class WeatherModel {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("query")
  private String query = null;

  @JsonProperty("observation_time")
  private String observationTime = null;

  @JsonProperty("temp_C")
  private String tempC = null;

  @JsonProperty("temp_F")
  private String tempF = null;

  @JsonProperty("weatherCode")
  private String weatherCode = null;

  @JsonProperty("weatherIconUrl")
  private String weatherIconUrl = null;

  @JsonProperty("weatherDesc")
  private String weatherDesc = null;

  public WeatherModel type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public WeatherModel query(String query) {
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @ApiModelProperty(value = "")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public WeatherModel observationTime(String observationTime) {
    this.observationTime = observationTime;
    return this;
  }

   /**
   * Get observationTime
   * @return observationTime
  **/
  @ApiModelProperty(value = "")
  public String getObservationTime() {
    return observationTime;
  }

  public void setObservationTime(String observationTime) {
    this.observationTime = observationTime;
  }

  public WeatherModel tempC(String tempC) {
    this.tempC = tempC;
    return this;
  }

   /**
   * Get tempC
   * @return tempC
  **/
  @ApiModelProperty(value = "")
  public String getTempC() {
    return tempC;
  }

  public void setTempC(String tempC) {
    this.tempC = tempC;
  }

  public WeatherModel tempF(String tempF) {
    this.tempF = tempF;
    return this;
  }

   /**
   * Get tempF
   * @return tempF
  **/
  @ApiModelProperty(value = "")
  public String getTempF() {
    return tempF;
  }

  public void setTempF(String tempF) {
    this.tempF = tempF;
  }

  public WeatherModel weatherCode(String weatherCode) {
    this.weatherCode = weatherCode;
    return this;
  }

   /**
   * Get weatherCode
   * @return weatherCode
  **/
  @ApiModelProperty(value = "")
  public String getWeatherCode() {
    return weatherCode;
  }

  public void setWeatherCode(String weatherCode) {
    this.weatherCode = weatherCode;
  }

  public WeatherModel weatherIconUrl(String weatherIconUrl) {
    this.weatherIconUrl = weatherIconUrl;
    return this;
  }

   /**
   * Get weatherIconUrl
   * @return weatherIconUrl
  **/
  @ApiModelProperty(value = "")
  public String getWeatherIconUrl() {
    return weatherIconUrl;
  }

  public void setWeatherIconUrl(String weatherIconUrl) {
    this.weatherIconUrl = weatherIconUrl;
  }

  public WeatherModel weatherDesc(String weatherDesc) {
    this.weatherDesc = weatherDesc;
    return this;
  }

   /**
   * Get weatherDesc
   * @return weatherDesc
  **/
  @ApiModelProperty(value = "")
  public String getWeatherDesc() {
    return weatherDesc;
  }

  public void setWeatherDesc(String weatherDesc) {
    this.weatherDesc = weatherDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeatherModel weatherModel = (WeatherModel) o;
    return Objects.equals(this.type, weatherModel.type) &&
        Objects.equals(this.query, weatherModel.query) &&
        Objects.equals(this.observationTime, weatherModel.observationTime) &&
        Objects.equals(this.tempC, weatherModel.tempC) &&
        Objects.equals(this.tempF, weatherModel.tempF) &&
        Objects.equals(this.weatherCode, weatherModel.weatherCode) &&
        Objects.equals(this.weatherIconUrl, weatherModel.weatherIconUrl) &&
        Objects.equals(this.weatherDesc, weatherModel.weatherDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, query, observationTime, tempC, tempF, weatherCode, weatherIconUrl, weatherDesc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherModel {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    observationTime: ").append(toIndentedString(observationTime)).append("\n");
    sb.append("    tempC: ").append(toIndentedString(tempC)).append("\n");
    sb.append("    tempF: ").append(toIndentedString(tempF)).append("\n");
    sb.append("    weatherCode: ").append(toIndentedString(weatherCode)).append("\n");
    sb.append("    weatherIconUrl: ").append(toIndentedString(weatherIconUrl)).append("\n");
    sb.append("    weatherDesc: ").append(toIndentedString(weatherDesc)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

