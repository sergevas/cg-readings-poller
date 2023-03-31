package dev.sergevas.iot.cg.readings.grower.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.grower.model.GrowerDeviceRequest;
import dev.sergevas.iot.cg.readings.shared.boundary.GrowlabV1ReadingsHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.event.model.SensorTypes.GROWER;

@ApplicationScoped
public class GrowerDeviceRequestHandler implements GrowlabV1ReadingsHandler<GrowerDeviceRequest> {

    @Inject
    ReadingsEventNatsAdapter readingsEventAdapter;

    @Override
    public void handle(GrowerDeviceRequest readings) {
        LOG.info("Have got a Grower Device request: " + readings);
        ReadingsEvent readingsEvent = this.toReadingsEvent(readings);
        LOG.info("Publish readings event: " + readingsEvent);
        readingsEventAdapter.send(readingsEvent);
    }

    public ReadingsEvent toReadingsEvent(GrowerDeviceRequest request) {
        ReadingsEvent readingsEvent = new ReadingsEventBuilder()
                .data(request)
                .eventId(UUID.randomUUID().toString())
                .deviceId(request.getDeviceId())
                .deviceName(request.getDeviceLabel())
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(request.getDate())
                .sensorType(GROWER)
                .build(x -> x);
        return readingsEvent;
    }
}
