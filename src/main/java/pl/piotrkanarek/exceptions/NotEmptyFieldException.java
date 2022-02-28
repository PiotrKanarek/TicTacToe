package pl.piotrkanarek.exceptions;

public class NotEmptyFieldException extends RuntimeException {

    public NotEmptyFieldException(String message) {
        super(message);
    }
}
