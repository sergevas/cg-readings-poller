package dev.sergevas.iot.cg.readings.event.boundary;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelNames.DIRECT_SEND_READINGS_EVENT;

@ApplicationScoped
@RegisterForReflection
public class NatsReadingsEventSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(DIRECT_SEND_READINGS_EVENT)
                .toD("nats:${bean:readingsEventHelper?method=topic}?servers=${bean:readingsEventNatsAdapter?method=natsServers}&maxReconnectAttempts=${bean:readingsEventNatsAdapter?method=natsMaxReconnects}&exchangePattern=InOnly");
    }
}
