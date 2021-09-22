package dev.sergevas.iot.cg.readings.event.controller;

import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.JsonbBuilder;

@ApplicationScoped
public class DomainUtils {

    public String serializeReadingsEvent(ReadingsEvent readingsEvent) {
        return  JsonbBuilder.create().toJson(readingsEvent);
    }
}
