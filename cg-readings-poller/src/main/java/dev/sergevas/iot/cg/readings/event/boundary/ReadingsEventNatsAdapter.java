package dev.sergevas.iot.cg.readings.event.boundary;

import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.camel.Produce;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelNames.DIRECT_SEND_READINGS_EVENT;

@ApplicationScoped
@RegisterForReflection
@Named("readingsEventNatsAdapter")
public class ReadingsEventNatsAdapter {

    @ConfigProperty(name="nats.servers")
    String natsServers;

    @ConfigProperty(name="nats.max.reconnects")
    Integer natsMaxReconnects;

    @ConfigProperty(name="nats.subject.cg.growlabv1")
    String natsSubjectCgGrowlabv1;

    @Produce(DIRECT_SEND_READINGS_EVENT)
    ReadingsEventListener readingsEventListener;

    public String natsServers() {
        return natsServers;
    }

    public Integer natsMaxReconnects() {
        return natsMaxReconnects;
    }

    public String natsSubjectCgGrowlabv1() {
        return natsSubjectCgGrowlabv1;
    }

    public void send(ReadingsEvent readingsEvent) {
        readingsEventListener.handle(readingsEvent);
    }

    public static interface ReadingsEventListener {
        void handle(ReadingsEvent readingsEvent);
    }
}
