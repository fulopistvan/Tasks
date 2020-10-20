package hu.kincstar.javasetraining.tasks;

public class GetOneStatusException extends RuntimeException {
    public GetOneStatusException() {
    }

    public GetOneStatusException(String message) {
        super(message);
    }

    public GetOneStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetOneStatusException(Throwable cause) {
        super(cause);
    }

    public GetOneStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
