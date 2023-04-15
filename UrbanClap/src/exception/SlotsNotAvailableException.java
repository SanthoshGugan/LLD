package exception;

public class SlotsNotAvailableException extends RuntimeException{

    public SlotsNotAvailableException(final String message) {
        super(message);
    }
}
