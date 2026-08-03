package fundb.exception;

// Generic exception used for better runtime control (report when something was expected to be
// handled at coding).
public class GenericRuntimeException extends RuntimeException {

    // Private constructor (available only through the pub. static methods).
    private GenericRuntimeException(String message) {
        super(message);
    }

    // When an abstract class (or interface) static function should be overrided on the child
    // implementor (but the overriding wasn't done).
    public static <P, C extends P> GenericRuntimeException staticFunctionNotImplemented(
        Class<C> childClass,
        Class<P> parentClass,
        String functionName
    ) {
        return new GenericRuntimeException(String.format(
            "`%s` class extends `%s` class/intr. but the `%s` static function requires overriding",
            childClass.getName(),
            parentClass.getName(),
            functionName
        ));
    }
}
