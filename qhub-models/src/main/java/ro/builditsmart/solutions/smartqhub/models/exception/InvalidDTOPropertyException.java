package ro.builditsmart.solutions.smartqhub.models.exception;

public class InvalidDTOPropertyException extends RuntimeException {

    public InvalidDTOPropertyException(String message) {
        super(message);
    }

    public InvalidDTOPropertyException(String message, Exception e) {
        super(message, e);
    }

}
