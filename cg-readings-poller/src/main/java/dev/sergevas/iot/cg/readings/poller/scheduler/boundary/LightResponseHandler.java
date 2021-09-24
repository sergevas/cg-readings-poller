package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.SensorReadingsItemType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.event.model.MeasurementUnits.LUX;
import static dev.sergevas.iot.cg.readings.event.model.SensorTypes.LIGHT;

@ApplicationScoped
public class LightResponseHandler implements GrowlabV1ApiResponseHandler<SensorReadingsItemType> {

    @ConfigProperty(name="device.id.growlabv1")
    String deviceId;

    @ConfigProperty(name="device.name.growlabv1")
    String deviceName;

    @Inject
    ReadingsEventNatsAdapter readingsEventAdapter;

    @Override
    public void handle(SensorReadingsItemType response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
        ReadingsEvent readingsEvent = this.toReadingsEvent(response);
        LOG.info("Publish a readings event: " + readingsEvent);
        readingsEventAdapter.send(readingsEvent);
    }

    public ReadingsEvent toReadingsEvent(SensorReadingsItemType sensorReadingsItemType) {
        ReadingsEvent readingsEvent = new ReadingsEventBuilder()
                .data(sensorReadingsItemType.getsData())
                .eventId(UUID.randomUUID().toString())
                .deviceId(this.deviceId)
                .deviceName(this.deviceName)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(sensorReadingsItemType.getsTimestamp())
                .sensorType(LIGHT)
                .measurementUnit(LUX)
                .build(Double::valueOf);
        return readingsEvent;
    }
}
