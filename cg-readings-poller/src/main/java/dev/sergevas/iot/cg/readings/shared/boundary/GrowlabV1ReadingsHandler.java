package dev.sergevas.iot.cg.readings.shared.boundary;

import org.jboss.logging.Logger;

public interface GrowlabV1ReadingsHandler<T> {

    static Logger LOG = Logger.getLogger(GrowlabV1ReadingsHandler.class);

    void handle(T readings);
}
