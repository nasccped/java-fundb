package fundb.token;

import fundb.database.command.AbstractCommand;
import fundb.regexing.RegexRecord;

// Refers to a token that is recognized as command (such as help, create, exit, ...).
public class CommandToken implements TokenInterface {

    // Inner value (command) held by this token.
    private final String INNER_VALUE;

    protected CommandToken(String value) {
        this.INNER_VALUE = value;
    }

    // Returns the inner value of the self `CommandToken` (command name).
    public String getInnerValue() {
        return INNER_VALUE;
    }

    // Returns the `RegexRecord` for a valid `CommandToken` matching. All the regex data is fetch
    // from the `AbstractCommand` static methods which provides the matching info.
    public static RegexRecord getRegexRecord() {
        return new RegexRecord(
            AbstractCommand.getRegexGroup(),
            AbstractCommand.getRegexPattern()
        );
    }
}
