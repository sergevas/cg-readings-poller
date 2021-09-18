package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.growlabv1.api.model.CameraModeType;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;

@ApplicationScoped
public class CameraImageResponseHandler implements GrowlabV1ApiResponseHandler<File> {

    @Override
    public void handle(File response) {
        LOG.info("Have got a GrowlabV1Api response: " + response);
    }
}
