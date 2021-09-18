package dev.sergevas.iot.cg.readings.poller.boundary;

import dev.sergevas.iot.cg.readings.poller.controller.PollerSchedulerService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class PollerControlResource {

    @Inject
    Logger logger;

    @Inject
    PollerSchedulerService pollerSchedulerService;

    @PUT
    @Path("/standby")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response putOnStandbyPoller() {
        logger.info("Put the poller on standby");
        pollerSchedulerService.putOnStandby();
        return Response
                .noContent()
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Path("/start")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response startPoller() {
        logger.info("Start the poller on standby");
        pollerSchedulerService.start();
        return Response
                .noContent()
                .status(Response.Status.OK)
                .build();
    }
}
