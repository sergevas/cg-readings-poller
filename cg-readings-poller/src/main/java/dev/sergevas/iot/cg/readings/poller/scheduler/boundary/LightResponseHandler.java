package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventListener;
import dev.sergevas.iot.cg.readings.event.model.DataItem;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.SensorReadingsItemType;
import org.apache.camel.Produce;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelComponentNames.DIRECT_SEND_READINGS_EVENT;
import static dev.sergevas.iot.cg.readings.event.model.MeasurementUnits.LUX;

@ApplicationScoped
public class LightResponseHandler implements GrowlabV1ApiResponseHandler<SensorReadingsItemType> {

    @ConfigProperty(name="device.id.growlabv1")
    String deviceId;

    @ConfigProperty(name="device.name.growlabv1")
    String deviceName;

    @ConfigProperty(name="cg.nats.topic.growlabv1.light")
    String natsTopic;

    @Produce(DIRECT_SEND_READINGS_EVENT)
    ReadingsEventListener readingsEventListener;

    @Override
    public void handle(SensorReadingsItemType response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
        readingsEventListener.handle(this.toReadingsEvent(response));
    }

    public ReadingsEvent toReadingsEvent(SensorReadingsItemType sensorReadingsItemType) {
        ReadingsEvent readingsEvent = new ReadingsEvent();
        readingsEvent.setEventId(UUID.randomUUID().toString());
        readingsEvent.setDeviceId(this.deviceId);
        readingsEvent.setDeviceName(this.deviceName);
        readingsEvent.setTopic(natsTopic);
        readingsEvent.setCreatedAt(OffsetDateTime.now(ZoneId.of("GMT")));
        readingsEvent.setReadAt(sensorReadingsItemType.getsTimestamp());
        readingsEvent.setData(new DataItem()
                .withUnit(LUX)
                .withValue(Optional
                        .ofNullable(sensorReadingsItemType.getsData())
                        .map(Double::valueOf)
                        .orElse(null)));
        return readingsEvent;
    }
}
