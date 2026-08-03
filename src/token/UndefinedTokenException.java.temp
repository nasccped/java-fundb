package fundb.token;

import fundb.repl.PrintableResultInterface;
import fundb.regexing.RegexRecord;

// When the passed token can't be recognized as valid one. Note that this function extends
// `RuntimeException` since a fail should be handled at Main's body instead of DatabaseManager.
public class UndefinedTokenException
extends RuntimeException
implements PrintableResultInterface, TokenInterface {

    // Inner value that leads to the exception.
    private final String INNER_VALUE;

    protected UndefinedTokenException(String value) {
        super(String.format("the \u001b[91m'%s'\u001b[0m token is undefined", value));
        this.INNER_VALUE = value;
    }

    // Returns the `RegexRecord` for the `UndefinedTokenException` matching. Note that the regex
    // pattern refers to any word-char +1 length (same as identifier). The actual matching is done
    // at `TokenFactory` list order.
    public static RegexRecord getRegexRecord() {
        return new RegexRecord("undefined", "\\w+");
    }

    // Returns the result inner status.
    public Status getStatus() {
        return PrintableResultInterface.Status.ERR;
    }

    // Returns the `UndefinedTokenException` inner value.
    public String getInnerValue() {
        return INNER_VALUE;
    }

    // Returns the action kind being ran.
    public String getActionKind() {
        return "token evaluation";
    }

    // Returns the fail description.
    public String getDescription() {
        return getMessage();
    }
}
