package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.CameraModeType;
import dev.sergevas.iot.cg.readings.shared.boundary.GrowlabV1ReadingsHandler;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.shared.model.SensorTypes.CAMERA_MODE;

@ApplicationScoped
public class CameraModeResponseHandler implements GrowlabV1ReadingsHandler<CameraModeType> {

    @ConfigProperty(name="device.id.growlabv1")
    String deviceId;

    @ConfigProperty(name="device.name.growlabv1")
    String deviceName;

    @ConfigProperty(name="cg.nats.subject.root")
    String rootNatsSubject;

    @Inject
    ReadingsEventNatsAdapter readingsEventAdapter;

    @Override
    public void handle(CameraModeType readings) {
        LOG.info("Have got a GrowlabV1Api response: " + readings);
        ReadingsEvent readingsEvent = this.toReadingsEvent(readings);
        LOG.info("Publish readings event: " + readingsEvent);
        readingsEventAdapter.send(readingsEvent);
    }

    public ReadingsEvent toReadingsEvent(CameraModeType sensorReadingsItemType) {
        return new ReadingsEventBuilder()
                .data(sensorReadingsItemType.getMode().value())
                .eventId(UUID.randomUUID().toString())
                .deviceId(this.deviceId)
                .deviceName(this.deviceName)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(sensorReadingsItemType.getModeTimestamp())
                .sensorType(CAMERA_MODE)
                .natsSubject(createSubjectName(CAMERA_MODE))
                .build(x -> x);
    }

    public String createSubjectName(String sensorType) {
        return rootNatsSubject +
                "." +
                deviceName +
                "." +
                sensorType;
    }
}
