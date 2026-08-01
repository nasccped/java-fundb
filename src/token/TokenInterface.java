package fundb.token;

import fundb.regexing.RegexRecord;

// Abstract token item, can be any valid token.
public interface TokenInterface {

    // Returns the `RegexRecord` linked with this kind of token.
    //
    // WARN: this function should be override on the implementor since it already have a body and
    //      can lead to runtime bugs.
    public static RegexRecord getRegexRecord() {
        return null;
    }

    // Returns the token inner value (String). Works similar to `Object.toString()` method but it
    // requires implementing.
    public String getInnerValue();

    // Default function used only for debug purposes.
    default String asDebugString() {
        return String.format("%s('%s')", getClass().getSimpleName(), getInnerValue());
    }
}
