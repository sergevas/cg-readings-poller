package dev.sergevas.iot.cg.readings.event.boundary;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelComponentNames.DIRECT_SEND_READINGS_EVENT;

@ApplicationScoped
public class NatsReadingsEventSender extends RouteBuilder {

    @ConfigProperty(name="nats.servers")
    String natsServers;

    @ConfigProperty(name="nats.max.reconnects")
    Integer natsMaxReconnects;

    @Override
    public void configure() throws Exception {
        from(DIRECT_SEND_READINGS_EVENT)
                .log("sendReadingsEventToNatsTopicStart")
                .marshal().json(JsonLibrary.Jsonb)
                .to()
                .log("sendReadingsEventToNatsTopicComplete");
    }
}
