package regexing;

// Interface for regex pattern unwrapping. Used across database and token packages.
public interface GetRegexPatternInterface {

    // Returns the regex pattern for the self item.
    //
    // BUG: this function should be override on the implementor since it already have a body and
    //      can lead to runtime bugs.
    static String getRegexPattern() {
        return null;
    }
}
