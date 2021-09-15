package dev.sergevas.iot.cg.readings.poller.boundary;

public class RequirementsNotSatisfiedException extends RuntimeException {

    public RequirementsNotSatisfiedException() {
    }

    public RequirementsNotSatisfiedException(String message) {
        super(message);
    }

    public RequirementsNotSatisfiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequirementsNotSatisfiedException(Throwable cause) {
        super(cause);
    }

    public RequirementsNotSatisfiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
