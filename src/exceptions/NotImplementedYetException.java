package fundb.exceptions;

// When some feature wasn't implemented yet.
public class NotImplementedYetException extends RuntimeException {

    public NotImplementedYetException(String featureName) {
        super(String.format("The '%s' feature wasn't implemented yet", featureName));
    }
}
