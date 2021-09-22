package dev.sergevas.iot.cg.readings.event.boundary;

public class AdapterException extends RuntimeException {

    public AdapterException() {
    }

    public AdapterException(String message) {
        super(message);
    }

    public AdapterException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdapterException(Throwable cause) {
        super(cause);
    }

    public AdapterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
