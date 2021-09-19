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
  * This type contains an actuator command request error description elements of the API
 **/

public class ActuatorErrorType  {
  
 /**
   * An error event type id
  **/
  @JsonbProperty("event_id")
  private String eventId;

 /**
   * An error event descriptive name
  **/
  @JsonbProperty("event_name")
  private String eventName;

 /**
   * An error event detailed info
  **/
  @JsonbProperty("desc")
  private String desc;

 /**
   * An error event occurrence timestamp
  **/
  @JsonbProperty("event_timestamp")
  private OffsetDateTime eventTimestamp;
  
 /**
   * An error event type id
   * @return eventId
  **/
  public String getEventId() {
    return eventId;
  }

  /**
    * Set eventId
  **/
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public ActuatorErrorType eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

 /**
   * An error event descriptive name
   * @return eventName
  **/
  public String getEventName() {
    return eventName;
  }

  /**
    * Set eventName
  **/
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public ActuatorErrorType eventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

 /**
   * An error event detailed info
   * @return desc
  **/
  public String getDesc() {
    return desc;
  }

  /**
    * Set desc
  **/
  public void setDesc(String desc) {
    this.desc = desc;
  }

  public ActuatorErrorType desc(String desc) {
    this.desc = desc;
    return this;
  }

 /**
   * An error event occurrence timestamp
   * @return eventTimestamp
  **/
  public OffsetDateTime getEventTimestamp() {
    return eventTimestamp;
  }

  /**
    * Set eventTimestamp
  **/
  public void setEventTimestamp(OffsetDateTime eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }

  public ActuatorErrorType eventTimestamp(OffsetDateTime eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
    return this;
  }


  /**
    * Create a string representation of this pojo.
  **/
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActuatorErrorType {\n");
    
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    eventTimestamp: ").append(toIndentedString(eventTimestamp)).append("\n");
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

