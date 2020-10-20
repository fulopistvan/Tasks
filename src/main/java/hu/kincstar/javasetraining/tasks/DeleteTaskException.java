package hu.kincstar.javasetraining.tasks;

public class DeleteTaskException extends RuntimeException{
    public DeleteTaskException() {
    }

    public DeleteTaskException(String message) {
        super(message);
    }

    public DeleteTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteTaskException(Throwable cause) {
        super(cause);
    }

    public DeleteTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
