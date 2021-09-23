package dev.sergevas.iot.cg.readings.event.boundary;

import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import org.apache.camel.InOnly;

@InOnly
public interface ReadingsEventListener {

    void handle(ReadingsEvent readingsData);
}
