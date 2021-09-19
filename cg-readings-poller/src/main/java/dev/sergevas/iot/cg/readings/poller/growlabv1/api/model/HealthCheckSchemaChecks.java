/**
 * OpenAPI spec for Raspberry Pi #growlab resources:
 * - GET temperature, humidity, and pressure readings
 * - GET light intensity readings
 * - GET RPi Camera module image
 * - GET RPi Camera module current mode
 * - PUT to set RPi Camera module current mode
 * - GET Health checks
 *
 * The version of the OpenAPI document: 1.0.0
 */

package dev.sergevas.iot.cg.readings.poller.growlabv1.api.model;


import javax.json.bind.annotation.JsonbProperty;


public class HealthCheckSchemaChecks  {
  
  @JsonbProperty("name")
  private String name;

  @JsonbProperty("status")
  private String status;

  @JsonbProperty("data")
  private Object data;
  
 /**
   * Get name
   * @return name
  **/
  public String getName() {
    return name;
  }

  /**
    * Set name
  **/
  public void setName(String name) {
    this.name = name;
  }

  public HealthCheckSchemaChecks name(String name) {
    this.name = name;
    return this;
  }

 /**
   * Get status
   * @return status
  **/
  public String getStatus() {
    return status;
  }

  /**
    * Set status
  **/
  public void setStatus(String status) {
    this.status = status;
  }

  public HealthCheckSchemaChecks status(String status) {
    this.status = status;
    return this;
  }

 /**
   * Get data
   * @return data
  **/
  public Object getData() {
    return data;
  }

  /**
    * Set data
  **/
  public void setData(Object data) {
    this.data = data;
  }

  public HealthCheckSchemaChecks data(Object data) {
    this.data = data;
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckSchemaChecks {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

