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
import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

/**
  * The Raspberry Pi IR-CUT camera operation mode.
 **/

public class CameraModeSetType  {
  
  @JsonbTypeSerializer(ModeEnum.Serializer.class)
  @JsonbTypeDeserializer(ModeEnum.Deserializer.class)
  public enum ModeEnum {

    NORM(String.valueOf("NORM")), NIGHT(String.valueOf("NIGHT"));    


    String value;

    ModeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static final class Deserializer implements JsonbDeserializer<ModeEnum> {
        @Override
        public ModeEnum deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
            for (ModeEnum b : ModeEnum.values()) {
                if (String.valueOf(b.value).equals(parser.getString())) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + parser.getString() + "'");
        }
    }

    public static final class Serializer implements JsonbSerializer<ModeEnum> {
        @Override
        public void serialize(ModeEnum obj, JsonGenerator generator, SerializationContext ctx) {
            generator.write(obj.value);
        }
    }
  }

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

