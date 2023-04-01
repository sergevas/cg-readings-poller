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

    @ConfigProperty(name="nats.username")
    String natsUserName;

    @ConfigProperty(name="nats.password")
    String natsPassword;

    @ConfigProperty(name="nats.max.reconnects")
    Integer natsMaxReconnects;

    @ConfigProperty(name="cg.nats.subject.growlabv1")
    String natsSubjectGrowlabv1;

    @Produce(DIRECT_SEND_READINGS_EVENT)
    ReadingsEventListener readingsEventListener;

    public String natsServers() {
        return natsServers;
    }

    public String natsUserName() {
        return natsUserName;
    }

    public String natsPassword() {
        return natsPassword;
    }

    public Integer natsMaxReconnects() {
        return natsMaxReconnects;
    }

    public String natsSubjectGrowlabv1() {
        return natsSubjectGrowlabv1;
    }

    public void send(ReadingsEvent readingsEvent) {
        readingsEventListener.handle(readingsEvent);
    }

    public static interface ReadingsEventListener {
        void handle(ReadingsEvent readingsEvent);
    }
}
