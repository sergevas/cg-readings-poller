package dev.sergevas.iot.cg.readings.poller.controller;

public class CgReadingsPollerException extends RuntimeException {

    public CgReadingsPollerException() {
    }

    public CgReadingsPollerException(String message) {
        super(message);
    }

    public CgReadingsPollerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CgReadingsPollerException(Throwable cause) {
        super(cause);
    }

    public CgReadingsPollerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
