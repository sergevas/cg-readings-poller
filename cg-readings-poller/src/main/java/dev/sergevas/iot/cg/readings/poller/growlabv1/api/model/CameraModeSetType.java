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

/**
  * The Raspberry Pi IR-CUT camera operation mode.
 **/


public class CameraModeSetType  {

    /**
   * The Raspberry Pi IR-CUT camera operation mode. Possible values:  - NORM - normal mode  - NIGHT - night mode
  **/
  @JsonbProperty("mode")
  private ModeEnum mode;
  
 /**
   * The Raspberry Pi IR-CUT camera operation mode. Possible values:  - NORM - normal mode  - NIGHT - night mode
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

  public CameraModeSetType mode(ModeEnum mode) {
    this.mode = mode;
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CameraModeSetType {\n");
    
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
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

