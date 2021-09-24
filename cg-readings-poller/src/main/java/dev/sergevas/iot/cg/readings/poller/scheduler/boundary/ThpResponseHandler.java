package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.SensorReadingsItemType;
import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.SensorReadingsType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.event.model.MeasurementUnits.*;
import static dev.sergevas.iot.cg.readings.event.model.SensorTypes.*;

@ApplicationScoped
public class ThpResponseHandler implements GrowlabV1ApiResponseHandler<SensorReadingsType> {

    @ConfigProperty(name="device.id.growlabv1")
    String deviceId;

    @ConfigProperty(name="device.name.growlabv1")
    String deviceName;

    @Inject
    ReadingsEventNatsAdapter readingsEventAdapter;

    @Override
    public void handle(SensorReadingsType response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
        List<SensorReadingsItemType> readings = response.getsReadings();

        readings.stream()
                .filter(r -> TEMP.equals(r.getsType()))
                .findAny()
                .ifPresent(r -> {
                    ReadingsEvent readingsEvent = this.toTempReadingsEvent(r);
                    LOG.info("Publish a readings event: " + readingsEvent);
                    readingsEventAdapter.send(readingsEvent);
                });
        readings.stream()
                .filter(r -> HUMID.equals(r.getsType()))
                .findAny()
                .ifPresent(r -> {
                    ReadingsEvent readingsEvent = this.toHumidReadingsEvent(r);
                    LOG.info("Publish a readings event: " + readingsEvent);
                    readingsEventAdapter.send(readingsEvent);
                });
        readings.stream()
                .filter(r -> PRESS.equals(r.getsType()))
                .findAny()
                .ifPresent(r -> {
                    ReadingsEvent readingsEvent = this.toPressReadingsEvent(r);
                    LOG.info("Publish a readings event: " + readingsEvent);
                    readingsEventAdapter.send(readingsEvent);
                });
    }

    public ReadingsEvent toTempReadingsEvent(SensorReadingsItemType sensorReadingsItemType) {
        ReadingsEvent readingsEvent = new ReadingsEventBuilder()
                .data(sensorReadingsItemType.getsData())
                .eventId(UUID.randomUUID().toString())
                .deviceId(this.deviceId)
                .deviceName(this.deviceName)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(sensorReadingsItemType.getsTimestamp())
                .sensorType(TEMP)
                .measurementUnit(DEGREE_CELSIUS)
                .build(Double::valueOf);
        return readingsEvent;
    }

    public ReadingsEvent toHumidReadingsEvent(SensorReadingsItemType sensorReadingsItemType) {
        ReadingsEvent readingsEvent = new ReadingsEventBuilder()
                .data(sensorReadingsItemType.getsData())
                .eventId(UUID.randomUUID().toString())
                .deviceId(this.deviceId)
                .deviceName(this.deviceName)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(sensorReadingsItemType.getsTimestamp())
                .sensorType(HUMID)
                .measurementUnit(PERCENTAGE)
                .build(Double::valueOf);
        return readingsEvent;
    }

    public ReadingsEvent toPressReadingsEvent(SensorReadingsItemType sensorReadingsItemType) {
        ReadingsEvent readingsEvent = new ReadingsEventBuilder()
                .data(sensorReadingsItemType.getsData())
                .eventId(UUID.randomUUID().toString())
                .deviceId(this.deviceId)
                .deviceName(this.deviceName)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(sensorReadingsItemType.getsTimestamp())
                .sensorType(PRESS)
                .measurementUnit(HECTOPASCAL)
                .build(Double::valueOf);
        return readingsEvent;
    }
}
