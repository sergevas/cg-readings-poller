package dev.sergevas.iot.cg.readings.poller.growlabv1.api.controller;

import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.ModeEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

@RegisterForReflection
public class ModeEnumDeserializer implements JsonbDeserializer<ModeEnum> {
    @Override
    public ModeEnum deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        for (ModeEnum b : ModeEnum.values()) {
            if (b.value().equals(parser.getString())) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + parser.getString() + "'");
    }
}
