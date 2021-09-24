package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.controller.ReadingsEventBuilder;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.HealthCheckSchema;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static dev.sergevas.iot.cg.readings.event.model.SensorTypes.HEALTH;

@ApplicationScoped
public class HealthResponseHandler implements GrowlabV1ApiResponseHandler<Response> {

    @ConfigProperty(name="device.id.growlabv1")
    String deviceId;

    @ConfigProperty(name="device.name.growlabv1")
    String deviceName;

    @ConfigProperty(name="cg.nats.subject.growlabv1.health")
    String natsSubject;

    @Inject
    ReadingsEventNatsAdapter readingsEventAdapter;

    @Override
    public void handle(Response response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
        ReadingsEvent readingsEvent = this.toReadingsEvent(response);
        LOG.info("Publish a readings event: " + readingsEvent);
        readingsEventAdapter.send(readingsEvent);
    }

    public ReadingsEvent toReadingsEvent(Response response) {
        HealthCheckSchema healthCheck = response.readEntity(HealthCheckSchema.class);
        ReadingsEvent readingsEvent = new ReadingsEventBuilder()
                .data(JsonbBuilder.create().toJson(healthCheck))
                .eventId(UUID.randomUUID().toString())
                .deviceId(this.deviceId)
                .deviceName(this.deviceName)
                .natsSubject(natsSubject)
                .createdAt(OffsetDateTime.now(ZoneId.of("GMT")))
                .readAt(OffsetDateTime.ofInstant(response.getDate().toInstant(), ZoneId.of("GMT")))
                .sensorType(HEALTH)
                .build(String::valueOf);
        return readingsEvent;
    }
}
