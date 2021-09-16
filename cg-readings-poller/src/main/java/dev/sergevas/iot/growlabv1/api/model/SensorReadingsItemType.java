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
import java.time.OffsetDateTime;

/**
  * A structure, containing sensor data readings, e.g. temperature, humidity, pressure, etc.
 **/

public class SensorReadingsItemType  {
  
 /**
   * A sensor type, e.g. TEMP (temperature)
  **/
  @JsonbProperty("s_type")
  private String sType;

 /**
   * Sensor id
  **/
  @JsonbProperty("s_id")
  private String sId;

 /**
   * A sensor readings value
  **/
  @JsonbProperty("s_data")
  private String sData;

 /**
   * Readings fetch timestamp
  **/
  @JsonbProperty("s_timestamp")
  private OffsetDateTime sTimestamp;
  
 /**
   * A sensor type, e.g. TEMP (temperature)
   * @return sType
  **/
  public String getsType() {
    return sType;
  }

  /**
    * Set sType
  **/
  public void setsType(String sType) {
    this.sType = sType;
  }

  public SensorReadingsItemType sType(String sType) {
    this.sType = sType;
    return this;
  }

 /**
   * Sensor id
   * @return sId
  **/
  public String getsId() {
    return sId;
  }

  /**
    * Set sId
  **/
  public void setsId(String sId) {
    this.sId = sId;
  }

  public SensorReadingsItemType sId(String sId) {
    this.sId = sId;
    return this;
  }

 /**
   * A sensor readings value
   * @return sData
  **/
  public String getsData() {
    return sData;
  }

  /**
    * Set sData
  **/
  public void setsData(String sData) {
    this.sData = sData;
  }

  public SensorReadingsItemType sData(String sData) {
    this.sData = sData;
    return this;
  }

 /**
   * Readings fetch timestamp
   * @return sTimestamp
  **/
  public OffsetDateTime getsTimestamp() {
    return sTimestamp;
  }

  /**
    * Set sTimestamp
  **/
  public void setsTimestamp(OffsetDateTime sTimestamp) {
    this.sTimestamp = sTimestamp;
  }

  public SensorReadingsItemType sTimestamp(OffsetDateTime sTimestamp) {
    this.sTimestamp = sTimestamp;
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorReadingsItemType {\n");
    
    sb.append("    sType: ").append(toIndentedString(sType)).append("\n");
    sb.append("    sId: ").append(toIndentedString(sId)).append("\n");
    sb.append("    sData: ").append(toIndentedString(sData)).append("\n");
    sb.append("    sTimestamp: ").append(toIndentedString(sTimestamp)).append("\n");
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

