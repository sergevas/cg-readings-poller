package dev.sergevas.iot.cg.readings.grower.boundary;

import dev.sergevas.iot.cg.readings.grower.model.GrowerDeviceRequest;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Path("/cg/device/grower")
public class GrowerDataReceiverResource {

    @Inject
    Logger logger;
    @Inject
    GrowerDeviceRequestHandler growerDeviceRequestHandler;

    @GET
    @Path("/{deviceId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGatewayCommand(@PathParam("deviceId") String deviceId,
                                      @QueryParam("tmp") Double soilTemp,
                                      @QueryParam("mst") Double soilMoisture,
                                      @QueryParam("pump") String pumpState) {
        logger.info(String.format("getGatewayCommand... deviceId=[%s], soilTemp=[%f], soilMoisture=[%f], pumpState=[%s]",
                deviceId, soilTemp, soilMoisture, pumpState));
        GrowerDeviceRequest growerDeviceRequest = new GrowerDeviceRequest(OffsetDateTime.now(ZoneId.of("GMT")),
                deviceId, soilTemp, soilMoisture, pumpState);
        logger.info(growerDeviceRequest);
        growerDeviceRequestHandler.handle(growerDeviceRequest);
        return Response
                .noContent()
                .status(Response.Status.OK)
                .build();
    }
}
