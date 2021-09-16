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

package dev.sergevas.iot.growlabv1.api.model;

import javax.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;
import java.util.List;


public class HealthCheckSchema  {
  
  @JsonbProperty("status")
  private String status;

  @JsonbProperty("checks")
  private List<HealthCheckSchemaChecks> checks = new ArrayList<>();
  
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

  public HealthCheckSchema status(String status) {
    this.status = status;
    return this;
  }

 /**
   * Get checks
   * @return checks
  **/
  public List<HealthCheckSchemaChecks> getChecks() {
    return checks;
  }

  /**
    * Set checks
  **/
  public void setChecks(List<HealthCheckSchemaChecks> checks) {
    this.checks = checks;
  }

  public HealthCheckSchema checks(List<HealthCheckSchemaChecks> checks) {
    this.checks = checks;
    return this;
  }

  public HealthCheckSchema addChecksItem(HealthCheckSchemaChecks checksItem) {
    this.checks.add(checksItem);
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckSchema {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
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

