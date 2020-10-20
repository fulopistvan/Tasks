package hu.kincstar.javasetraining.tasks;

public class SetConnectionException extends RuntimeException{
    public SetConnectionException() {
    }

    public SetConnectionException(String message) {
        super(message);
    }

    public SetConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetConnectionException(Throwable cause) {
        super(cause);
    }

    public SetConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
