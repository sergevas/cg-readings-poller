package dev.sergevas.iot.cg.readings.grower.boundary;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cg/device/grower")
public class GrowerDataReceiverResource {

    @Inject
    Logger logger;

    @GET
    @Path("/{deviceId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGatewayCommand(@PathParam("deviceId") String deviceId,
                                      @QueryParam("tmp") String soilTemp,
                                      @QueryParam("mst") String soilMoisture,
                                      @QueryParam("pump") String pumpState) {
        logger.info(String.format("getGatewayCommand... deviceId=[%s], soilTemp=[%s], soilMoisture=[%s], pumpState=[%s]",
                deviceId, soilTemp, soilMoisture, pumpState));
        return Response
                .noContent()
                .status(Response.Status.OK)
                .build();
    }
}
