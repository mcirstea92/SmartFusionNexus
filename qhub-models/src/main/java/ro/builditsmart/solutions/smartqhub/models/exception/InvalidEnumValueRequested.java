package ro.builditsmart.solutions.smartqhub.models.exception;

public class InvalidEnumValueRequested extends RuntimeException {

    public InvalidEnumValueRequested(Object obj, Class<?> type) {
        super("Invalid enum value requested: " + obj + " from " + type.toString());
    }

}
