package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.growlabv1.api.model.CameraModeType;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CameraModeResponseHandler implements GrowlabV1ApiResponseHandler<CameraModeType> {

    @Override
    public void handle(CameraModeType response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
    }
}
