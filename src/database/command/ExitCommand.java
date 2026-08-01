package fundb.database.command;

// Refers to the `exit` command called on the prompt.
public abstract class ExitCommand extends AbstractCommand {

    // Returns the valid regex pattern for the `ExitCommand` action.
    public static String getRegexPattern() {
        return "exit";
    }
}
