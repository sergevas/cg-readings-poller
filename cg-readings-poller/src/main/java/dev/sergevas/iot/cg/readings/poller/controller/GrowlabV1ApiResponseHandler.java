package dev.sergevas.iot.cg.readings.poller.controller;

import org.jboss.logging.Logger;

public interface GrowlabV1ApiResponseHandler<T> {

    static Logger LOG = Logger.getLogger(GrowlabV1ApiResponseHandler.class);

    void handle(T response);
}
