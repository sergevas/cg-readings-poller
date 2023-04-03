package dev.sergevas.iot.cg.readings.grower.boundary;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Inject
    Logger logger;
    @Override
    public Response toResponse(RuntimeException exception) {
        logger.warn(exception);
        return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN).build();
    }
}
