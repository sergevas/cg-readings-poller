package dev.sergevas.iot.cg.readings.poller.scheduler.boundary;

import dev.sergevas.iot.cg.readings.shared.boundary.GrowlabV1ReadingsHandler;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;

@ApplicationScoped
public class CameraImageResponseHandler implements GrowlabV1ReadingsHandler<File> {

    @Override
    public void handle(File readings) {
        LOG.info("Have got a GrowlabV1Api response: " + readings);
    }
}
