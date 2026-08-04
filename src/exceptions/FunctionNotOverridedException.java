package fundb.exceptions;

// When a function (static) is expected to be overrided at class extenders.
public class FunctionNotOverridedException extends RuntimeException {

    public FunctionNotOverridedException(String functionReference) {
        super(String.format(
            "`%s` function was expected to be overrided on the final extender",
            functionReference
        ));
    }
}
