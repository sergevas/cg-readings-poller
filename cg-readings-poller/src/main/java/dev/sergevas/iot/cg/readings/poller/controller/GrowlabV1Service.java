package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.cg.readings.poller.boundary.TaskCode;
import dev.sergevas.iot.growlabv1.api.boundary.GrowlabV1Api;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class GrowlabV1Service {

    @Inject
    private Logger logger;

    @Inject
    @RestClient
    private GrowlabV1Api growlabV1Api;

    public void onTaskCode(@Observes TaskCode taskCode) {
        logger.info("* * * * * * * * * * Have got task code * * * * * * * * * * " + taskCode);
    }
}
