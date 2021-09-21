package dev.sergevas.iot.cg.readings.event.boundary;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;

import static dev.sergevas.iot.cg.readings.event.boundary.CamelComponentNames.DIRECT_SEND_READINGS_EVENT;

@ApplicationScoped
public class LightReadingsSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(DIRECT_SEND_READINGS_EVENT)
                .log("sendReadingsEventToNatsTopicStart")
                .marshal().json(JsonLibrary.Jsonb)
                .log("sendReadingsEventToNatsTopicComplete");
    }
}
