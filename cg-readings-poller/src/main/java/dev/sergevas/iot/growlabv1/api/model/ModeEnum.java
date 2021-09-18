package dev.sergevas.iot.growlabv1.api.model;

import dev.sergevas.iot.growlabv1.api.controller.ModeEnumDeserializer;
import dev.sergevas.iot.growlabv1.api.controller.ModeEnumSerializer;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.json.bind.annotation.JsonbTypeSerializer;

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
