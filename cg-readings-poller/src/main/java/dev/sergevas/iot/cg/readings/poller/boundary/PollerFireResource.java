package dev.sergevas.iot.cg.readings.poller.boundary;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class PollerFireResource {

    @Inject
    Logger logger;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response firePoller() {
        logger.info("Fire the Connected garden readings poller");
        return Response
                .noContent()
                .status(Response.Status.ACCEPTED)
                .build();
    }
}
