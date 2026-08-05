package fundb.regex;

// Interface for `RegexHelper` getting.
public interface GetRegexHelperInterface {

    // Returns the `RegexHelper` associated with the self class (not object, since it's a static
    // method). This function should be overrided on the final implementor.
    public static RegexHelper getRegexHelper() {
        throw new FunctionNotOverridedException("GetRegexHelperInterface::getRegexHelper");
    }
}
