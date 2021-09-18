package dev.sergevas.iot.cg.readings.poller.boundary;

import dev.sergevas.iot.cg.readings.poller.controller.*;
import dev.sergevas.iot.cg.readings.poller.model.TaskCode;
import dev.sergevas.iot.cg.readings.poller.model.TaskType;
import dev.sergevas.iot.growlabv1.api.boundary.GrowlabV1Api;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class GrowlabV1Service {

    @Inject
    Logger logger;

    @Inject
    @RestClient
    GrowlabV1Api growlabV1Api;

    @Inject
    LightResponseHandler lightResponseHandler;

    @Inject
    ThpResponseHandler thpResponseHandler;

    @Inject
    HealthResponseHandler healthResponseHandler;

    @Inject
    CameraModeResponseHandler cameraModeResponseHandler;

    @Inject
    CameraImageResponseHandler imageResponseHandler;

    public void onTaskCode(@Observes TaskCode taskCode) {
        logger.info("Have got task code: " + taskCode);
        TaskType taskType = Optional.ofNullable(TaskType.getByCode(taskCode.getCode()))
                .orElseThrow(() -> new RequirementsNotSatisfiedException(String
                        .format("Unable to find TaskType instance for taskCode [%s]", taskCode)));
       this.processTaskType(taskType);
    }

    private void processTaskType(TaskType taskType) {
        switch (taskType) {
            case LIGHT:
                this.lightResponseHandler.handle(this.growlabV1Api.getLightIntensity());
                break;
            case THP:
                this.thpResponseHandler.handle(this.growlabV1Api.getThp());
                break;
            case HEALTH:
                this.healthResponseHandler.handle(this.growlabV1Api.getHealthChecks());
                break;
            case CAMERA_MODE:
                this.cameraModeResponseHandler.handle(this.growlabV1Api.getCameraMode());
                break;
            case CAMERA_IMAGE:
                this.imageResponseHandler.handle(this.growlabV1Api.getImage());
        }
    }
}
