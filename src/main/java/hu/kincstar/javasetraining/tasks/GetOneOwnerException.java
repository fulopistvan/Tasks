package hu.kincstar.javasetraining.tasks;

public class GetOneOwnerException extends RuntimeException {
    public GetOneOwnerException() {
    }

    public GetOneOwnerException(String message) {
        super(message);
    }

    public GetOneOwnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetOneOwnerException(Throwable cause) {
        super(cause);
    }

    public GetOneOwnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
