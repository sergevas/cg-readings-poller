/**
 * OpenAPI spec for Raspberry Pi #growlab resources:
 * - GET temperature, humidity, and pressure readings
 * - GET light intensity readings
 * - GET RPi Camera module image
 * - GET RPi Camera module current mode
 * - PUT to set RPi Camera module current mode
 * - GET Health checks
 *
 * The version of the OpenAPI document: 1.0.0
 */

package dev.sergevas.iot.growlabv1.api.boundary;

import dev.sergevas.iot.growlabv1.api.model.CameraModeSetType;
import dev.sergevas.iot.growlabv1.api.model.CameraModeType;
import dev.sergevas.iot.growlabv1.api.model.SensorReadingsItemType;
import dev.sergevas.iot.growlabv1.api.model.SensorReadingsType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

/**
 * OpenAPI spec for Raspberry Pi #growlab resources
 *
 * <p>OpenAPI spec for Raspberry Pi #growlab resources:
 * - GET temperature, humidity, and pressure readings
 * - GET light intensity readings
 * - GET RPi Camera module image
 * - GET RPi Camera module current mode
 * - PUT to set RPi Camera module current mode
 * - GET Health checks
 */

@RegisterRestClient
@RegisterProvider(ApiExceptionMapper.class)
@Path("")
public interface DefaultApi  {

    /**
     * Get camera mode
     *
     * Can be used to get the camera current mode of operation
     *
     */
    @GET
    @Path("/actuators/camera/mode")
    @Produces({ "application/json" })
    public CameraModeType getCameraMode() throws ApiException, ProcessingException;

    /**
     * Can be used to get health checks
     *
     * Can be used to get the health information of the runtime
     *
     */
    @GET
    @Path("/health")
    @Produces({ "application/json" })
    public void getHealthChecks() throws ApiException, ProcessingException;

    /**
     * Take and get an image from the Raspberry Pi camera
     *
     * This operation allows to take and get an image from the Raspberry Pi camera
     *
     */
    @GET
    @Path("/actuators/camera/image")
    @Produces({ "application/octet-stream", "application/json" })
    public void getImage() throws ApiException, ProcessingException;

    /**
     * Get light intensity readings
     *
     * Can be used to get readings the light intensity sensor
     *
     */
    @GET
    @Path("/sensors/light")
    @Produces({ "application/json" })
    public SensorReadingsItemType getLightIntensity() throws ApiException, ProcessingException;

    /**
     * Get temperature, humidity and pressure readings
     *
     * Can be used to get readings of temperature, humidity, and pressure readings, obtained from the environmental data sensor, e.g. BME280
     *
     */
    @GET
    @Path("/sensors/thp")
    @Produces({ "application/json" })
    public SensorReadingsType getThp() throws ApiException, ProcessingException;

    /**
     * Set the camera operation mode
     *
     * Can be used to set the camera operation mode
     *
     */
    @PUT
    @Path("/actuators/camera/mode")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public void putCameraMode(CameraModeSetType cameraModeSetType) throws ApiException, ProcessingException;
}

