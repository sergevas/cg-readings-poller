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
import java.util.List;

/**
  * An array of sensors readings
 **/

public class SensorReadingsType  {
  
 /**
   * Sensor readings
  **/
  @JsonbProperty("s_readings")
  private List<SensorReadingsItemType> sReadings = null;
  
 /**
   * Sensor readings
   * @return sReadings
  **/
  public List<SensorReadingsItemType> getsReadings() {
    return sReadings;
  }

  /**
    * Set sReadings
  **/
  public void setsReadings(List<SensorReadingsItemType> sReadings) {
    this.sReadings = sReadings;
  }

  public SensorReadingsType sReadings(List<SensorReadingsItemType> sReadings) {
    this.sReadings = sReadings;
    return this;
  }

  public SensorReadingsType addSReadingsItem(SensorReadingsItemType sReadingsItem) {
    this.sReadings.add(sReadingsItem);
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorReadingsType {\n");
    
    sb.append("    sReadings: ").append(toIndentedString(sReadings)).append("\n");
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

