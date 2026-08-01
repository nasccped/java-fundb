package fundb.token;

import fundb.regexing.RegexRecord;

// Refers to the semicolon token (';').
public class SemicolonToken implements TokenInterface {

    private final String INNER_VALUE;

    protected SemicolonToken() {
        this.INNER_VALUE = ";";
    }

    // Returns the `RegexRecord` for a `SemicolonToken` matching.
    public static RegexRecord getRegexRecord() {
        return new RegexRecord("semicolon", "\\;");
    }

    public String getInnerValue() {
        return INNER_VALUE;
    }
}
