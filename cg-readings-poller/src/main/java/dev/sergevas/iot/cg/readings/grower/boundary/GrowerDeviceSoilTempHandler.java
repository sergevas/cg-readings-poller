package dev.sergevas.iot.cg.readings.grower.boundary;

import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.grower.model.GrowerDeviceRequest;

import javax.enterprise.context.ApplicationScoped;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.event.model.MeasurementUnits.DEGREE_CELSIUS;
import static dev.sergevas.iot.cg.readings.shared.model.DeviceTypes.GROWER;
import static dev.sergevas.iot.cg.readings.shared.model.SensorTypes.SOIL_TEMP;

@ApplicationScoped
public class GrowerDeviceSoilTempHandler extends GrowerDeviceRequestHandler {

    public ReadingsEvent toReadingsEvent(GrowerDeviceRequest request) {
        return new ReadingsEventBuilder()
                .data(request.getSoilTemp())
                .measurementUnit(DEGREE_CELSIUS)
                .eventId(UUID.randomUUID().toString())
                .deviceId(request.getDeviceId())
                .deviceName(request.getDeviceName())
                .deviceType(GROWER)
                .sensorType(SOIL_TEMP)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(request.getDate())
                .natsSubject(createSubjectName(request.getDeviceId(), SOIL_TEMP))
                .build(x -> x);
    }
}
