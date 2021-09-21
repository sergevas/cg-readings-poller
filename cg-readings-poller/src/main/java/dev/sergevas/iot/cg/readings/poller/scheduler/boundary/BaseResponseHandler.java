package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;


import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventListener;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import org.apache.camel.Produce;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Default;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelComponentNames.DIRECT_SEND_READINGS_EVENT;

public abstract class BaseResponseHandler<T> implements GrowlabV1ApiResponseHandler<T> {

//    @ConfigProperty(name="device.id.growlabv1")
//    String deviceId;
//
//    @ConfigProperty(name="device.name.growlabv1")
//    String deviceName;
//
//    @Produce(DIRECT_SEND_READINGS_EVENT)
//    ReadingsEventListener<ReadingsEvent> readingsEventListener;

    public abstract void handle(T response);
}
