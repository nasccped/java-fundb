package fundb.database.command;

import java.util.List;
import java.util.stream.Collectors;
import fundb.regexing.GetRegexGroupInterface;
import fundb.regexing.GetRegexPatternInterface;

// Abstract shape of a database command, such as help, exit, create, ...
//
// This class just holds the regex group and patterns used with token and repl packages.
public abstract class AbstractCommand
implements GetRegexGroupInterface, GetRegexPatternInterface {

    // Patterns of `AbstractCommand` extenders.
    private static final List<String> patterns = List.of(
        ExitCommand.getRegexPattern(),
        HelpCommand.getRegexPattern()
    );

    // Returns the regex group name for all `AbstractCommand` extenders.
    public static String getRegexGroup() {
        return "cmd";
    }

    // Returns the regex pattern joined for all `AbstractCommand` extenders (refers to `patterns`
    // field).
    public static String getRegexPattern() {
        return patterns.stream().collect(Collectors.joining("|"));
    }
}
