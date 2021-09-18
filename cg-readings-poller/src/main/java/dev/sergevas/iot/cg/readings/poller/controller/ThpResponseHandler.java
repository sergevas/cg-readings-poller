package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.growlabv1.api.model.SensorReadingsType;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ThpResponseHandler implements GrowlabV1ApiResponseHandler<SensorReadingsType> {

    @Override
    public void handle(SensorReadingsType response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
    }
}
