package dev.sergevas.iot.cg.readings.event.controller;

import dev.sergevas.iot.cg.readings.event.boundary.ReadingsEventNatsAdapter;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@RegisterForReflection
@Named("readingsEventHelper")
public class ReadingsEventHelper {

    @Inject
    ReadingsEventNatsAdapter readingsEventNatsAdapter;

    public String topic(ReadingsEvent readingsEvent) {
        String topic = new StringBuilder(readingsEventNatsAdapter.natsSubjectGrowlabv1())
                .append(".")
                .append(readingsEvent.getData().getType())
                .toString();
        System.out.println(topic);
        return topic;
    }
}
