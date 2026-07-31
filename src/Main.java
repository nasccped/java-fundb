import java.util.HashMap;

class Main {

    // Used prompt when asking for user.
    private static final String PROMPT_INDICATOR = "> ";

    // Variable to store the user response.
    private static String userResponse;

    // Variable used to check if the program should continue.
    private static boolean continueProgram = true;

    public static void main(String[] args) {
        String boldQuit = String.format("\u001b[1m%s\u001b[0m", "quit;");
        String boldHelp = String.format("\u001b[1m%s\u001b[0m", "help;");

        // Print welcome message.
        IOHandler.setLeftGap(2);
        IOHandler.println();
        IOHandler.println("Welcome to java-fundb, a database REPL made on my free time!");
        IOHandler.println(String.format(
            "You can use '%s' or '%s' at any time. Have fun!\n",
            boldQuit,
            boldHelp
        ));

        // while program run.
        while (continueProgram) {

            userResponse = IOHandler.prompt(PROMPT_INDICATOR);

            if (userResponse.equalsIgnoreCase("quit;"))
                setContinueProgram(false);
            else if (userResponse.equalsIgnoreCase("help;"))
                IOHandler.println("TODO: print help panel here...");
        }

        // Say bye...
        IOHandler.println();
        IOHandler.println("Exiting program...\n");
    }

    // Set a new value to the private continueProgram field.
    protected static void setContinueProgram(boolean value) {
        continueProgram = value;
    }
}
