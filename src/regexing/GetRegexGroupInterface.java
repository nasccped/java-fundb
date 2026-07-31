package regexing;

// Interface for regex group name unwrapping. Used across database and token packages.
public interface GetRegexGroupInterface {

    // Returns the regex group name for the self item.
    //
    // BUG: this function should be override on the implementor since it already have a body and
    //      can lead to runtime bugs.
    static String getRegexGroup() {
        return null;
    }
}
