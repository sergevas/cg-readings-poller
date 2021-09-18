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

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ResponseExceptionMapper<ApiException> {

  @Override
  public boolean handles(int status, MultivaluedMap<String, Object> headers) {
    return status >= 400;
  }

  @Override
  public ApiException toThrowable(Response response) {
    return new ApiException(response);
  }
}
