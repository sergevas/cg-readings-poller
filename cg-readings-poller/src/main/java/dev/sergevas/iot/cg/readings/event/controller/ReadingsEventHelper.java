package dev.sergevas.iot.cg.readings.event.controller;

import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@RegisterForReflection
@Named("readingsEventHelper")
public class ReadingsEventHelper {

    public String topic(ReadingsEvent readingsEvent) {
        return readingsEvent.getTopic();
    }
}
