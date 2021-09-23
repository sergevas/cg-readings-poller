package dev.sergevas.iot.cg.readings.event.boundary;

import io.nats.client.Connection;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

@RegisterForReflection
@ApplicationScoped
public class NatsAdapter {

    @Inject
    Connection connection;

    public void publish(String subject, String message) {
        connection.publish(subject, message.getBytes(StandardCharsets.UTF_8));
    }
}
