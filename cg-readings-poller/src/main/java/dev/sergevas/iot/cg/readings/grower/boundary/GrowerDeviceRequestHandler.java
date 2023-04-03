package dev.sergevas.iot.cg.readings.grower.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.grower.model.GrowerDeviceRequest;
import dev.sergevas.iot.cg.readings.shared.boundary.GrowlabV1ReadingsHandler;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GrowerDeviceRequestHandler implements GrowlabV1ReadingsHandler<GrowerDeviceRequest> {

    @Inject
    ReadingsEventNatsAdapter readingsEventAdapter;

    @ConfigProperty(name = "cg.nats.subject.root")
    String rootNatsSubject;

    @Override
    public void handle(GrowerDeviceRequest readings) {
        LOG.info("Have got a Grower Device request: " + readings);
        ReadingsEvent readingsEvent = this.toReadingsEvent(readings);
        LOG.info("Publish readings event: " + readingsEvent);
        readingsEventAdapter.send(readingsEvent);
    }

    public ReadingsEvent toReadingsEvent(GrowerDeviceRequest request) {
        throw new UnsupportedOperationException();
    }

    public String createSubjectName(String deviceId, String sensorType) {
        return rootNatsSubject +
                "." +
                deviceId +
                "." +
                sensorType;
    }
}
