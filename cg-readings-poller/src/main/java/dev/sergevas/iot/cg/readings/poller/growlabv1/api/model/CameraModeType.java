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
import java.time.OffsetDateTime;

/**
  * The Raspberry Pi IR-CUT camera current mode of operation.
 **/

public class CameraModeType  {
  
 /**
   * The Raspery Pi IR-CUT camera mode.
  **/
  @JsonbProperty("mode")
  private ModeEnum mode;

 /**
   * The camera mode fetch timestamp
  **/
  @JsonbProperty("mode_timestamp")
  private OffsetDateTime modeTimestamp;
  
 /**
   * The Raspery Pi IR-CUT camera mode.
   * @return mode
  **/
  public ModeEnum getMode() {
    return mode;
  }

  /**
    * Set mode
  **/
  public void setMode(ModeEnum mode) {
    this.mode = mode;
  }

  public CameraModeType mode(ModeEnum mode) {
    this.mode = mode;
    return this;
  }

 /**
   * The camera mode fetch timestamp
   * @return modeTimestamp
  **/
  public OffsetDateTime getModeTimestamp() {
    return modeTimestamp;
  }

  /**
    * Set modeTimestamp
  **/
  public void setModeTimestamp(OffsetDateTime modeTimestamp) {
    this.modeTimestamp = modeTimestamp;
  }

  public CameraModeType modeTimestamp(OffsetDateTime modeTimestamp) {
    this.modeTimestamp = modeTimestamp;
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CameraModeType {\n");
    
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    modeTimestamp: ").append(toIndentedString(modeTimestamp)).append("\n");
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

