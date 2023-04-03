package dev.sergevas.iot.cg.readings.grower.boundary;

import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.grower.model.GrowerDeviceRequest;

import javax.enterprise.context.ApplicationScoped;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.shared.model.DeviceTypes.GROWER;
import static dev.sergevas.iot.cg.readings.shared.model.SensorTypes.PUMP_STATE;

@ApplicationScoped
public class GrowerDevicePumpStateHandler extends GrowerDeviceRequestHandler {

    public ReadingsEvent toReadingsEvent(GrowerDeviceRequest request) {
        return new ReadingsEventBuilder()
                .data(request.getPumpStat())
                .eventId(UUID.randomUUID().toString())
                .deviceId(request.getDeviceId())
                .deviceName(request.getDeviceName())
                .deviceType(GROWER)
                .sensorType(PUMP_STATE)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(request.getDate())
                .natsSubject(createSubjectName(request.getDeviceId(), PUMP_STATE))
                .build(x -> x);
    }
}
