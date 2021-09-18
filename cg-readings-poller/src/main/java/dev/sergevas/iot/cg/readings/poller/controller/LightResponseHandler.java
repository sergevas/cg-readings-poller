package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.growlabv1.api.model.SensorReadingsItemType;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LightResponseHandler implements GrowlabV1ApiResponseHandler<SensorReadingsItemType> {

    @Override
    public void handle(SensorReadingsItemType response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
    }
}
