package dev.sergevas.iot.cg.readings.event.boundary;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class NatsConnectionProducer {

    @ConfigProperty(name="nats.host")
    String natsHost;

    @ConfigProperty(name="nats.port")
    Integer natsPort;

    @ConfigProperty(name="nats.max.reconnects")
    Integer natsMaxReconnects;

    @Produces
    public Connection getConnection() {
        String natsServerUrl = new StringBuilder("nats://")
                .append(natsHost)
                .append(":")
                .append(natsPort).toString();
        Options o = new Options.Builder()
                .server(natsServerUrl)
                .maxReconnects(natsMaxReconnects)
                .build();
        Connection natsConnection;
        try {
            natsConnection = Nats.connect(o);
        } catch (IOException | InterruptedException e) {
            throw new AdapterException(String.format("Unable to connect to NATS server [%s]", natsServerUrl));
        }
        return natsConnection;
    }
}
