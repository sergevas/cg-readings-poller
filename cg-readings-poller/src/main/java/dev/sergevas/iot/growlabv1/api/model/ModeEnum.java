package dev.sergevas.iot.growlabv1.api.model;

import dev.sergevas.iot.growlabv1.api.controller.ModeEnumDeserializer;
import dev.sergevas.iot.growlabv1.api.controller.ModeEnumSerializer;
import dev.sergevas.iot.growlabv1.api.model.CameraModeSetType;

import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

@JsonbTypeSerializer(ModeEnumSerializer.class)
@JsonbTypeDeserializer(ModeEnumDeserializer.class)
public enum ModeEnum {

    NORM("NORM"), NIGHT("NIGHT");

    String value;

    ModeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
