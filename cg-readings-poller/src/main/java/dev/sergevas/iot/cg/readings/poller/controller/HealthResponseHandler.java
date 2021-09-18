package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.growlabv1.api.model.HealthCheckSchema;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HealthResponseHandler implements GrowlabV1ApiResponseHandler<HealthCheckSchema> {

    @Override
    public void handle(HealthCheckSchema response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
    }
}
