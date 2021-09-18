package dev.sergevas.iot.growlabv1.api.controller;

import dev.sergevas.iot.growlabv1.api.model.ModeEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

@RegisterForReflection
public class ModeEnumSerializer implements JsonbSerializer<ModeEnum> {

    @Override
    public void serialize(ModeEnum obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.value());
    }
}
