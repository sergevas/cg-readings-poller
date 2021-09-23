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

package dev.sergevas.iot.cg.readings.poller.growlabv1.api.boundary;

import dev.sergevas.iot.cg.readings.poller.growlabv1.api.model.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;

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

@RegisterRestClient(configKey = "growlabv1-api")
public interface GrowlabV1Api {

    /**
     * Get camera mode
     *
     * Can be used to get the camera current mode of operation
     *
     */
    @GET
    @Path("/actuators/camera/mode")
    @Produces({ "application/json" })
    CameraModeType getCameraMode() throws ApiException, ProcessingException;

    /**
     * Can be used to get health checks
     *
     * Can be used to get the health information of the runtime
     *
     */
    @GET
    @Path("/health")
    @Produces({ "application/json" })
    Response getHealthChecks() throws ApiException, ProcessingException;

    /**
     * Take and get an image from the Raspberry Pi camera
     *
     * This operation allows to take and get an image from the Raspberry Pi camera
     *
     */
    @GET
    @Path("/actuators/camera/image")
    @Produces({ "application/octet-stream", "application/json" })
    File getImage() throws ApiException, ProcessingException;

    /**
     * Get light intensity readings
     *
     * Can be used to get readings the light intensity sensor
     *
     */
    @GET
    @Path("/sensors/light")
    @Produces({ "application/json" })
    SensorReadingsItemType getLightIntensity() throws ApiException, ProcessingException;

    /**
     * Get temperature, humidity and pressure readings
     *
     * Can be used to get readings of temperature, humidity, and pressure readings, obtained from the environmental data sensor, e.g. BME280
     *
     */
    @GET
    @Path("/sensors/thp")
    @Produces({ "application/json" })
    SensorReadingsType getThp() throws ApiException, ProcessingException;

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
    void putCameraMode(CameraModeSetType cameraModeSetType) throws ApiException, ProcessingException;
}

