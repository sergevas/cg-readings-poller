package dev.sergevas.iot.cg.readings.event.boundary;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelNames.DIRECT_SEND_READINGS_EVENT;
import static dev.sergevas.iot.cg.readings.event.boundary.CamelNames.NATS_TOPIC;

@ApplicationScoped
@RegisterForReflection
public class NatsReadingsEventSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(DIRECT_SEND_READINGS_EVENT)
                .setHeader(NATS_TOPIC, simple("${bean:readingsEventHelper?method=topic}"))
                .marshal().json(JsonLibrary.Jsonb)
                .toD("nats:${header.NATS_TOPIC}?servers=${bean:readingsEventNatsAdapter?method=natsServers}&maxReconnectAttempts=${bean:readingsEventNatsAdapter?method=natsMaxReconnects}&exchangePattern=InOnly");
    }
}
