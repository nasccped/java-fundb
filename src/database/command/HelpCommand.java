package fundb.database.command;

// Refers to the `help` command called on the prompt.
public abstract class HelpCommand extends AbstractCommand {

    // Returns the valid regex pattern for the `HelpCommand` action.
    public static String getRegexPattern() {
        return "help";
    }
}
