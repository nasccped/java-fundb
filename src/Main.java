import java.util.HashMap;
import repl.Reader;

class Main {

    // Used prompt when asking for user.
    private static final String PROMPT_INDICATOR = "> ";

    // Variable to store the user response.
    private static String userResponse;

    // Variable used to check if the program should continue.
    private static boolean continueProgram = true;

    public static void main(String[] args) {
        String boldExit = String.format("\u001b[1m%s\u001b[0m", "exit;");
        String boldHelp = String.format("\u001b[1m%s\u001b[0m", "help;");

        // Print welcome message.
        IOHandler.setLeftGap(2);
        IOHandler.println();
        IOHandler.println("Welcome to java-fundb, a database REPL made on my free time!");
        IOHandler.println(String.format(
            "You can use '%s' or '%s' at any time. Have fun!\n",
            boldExit,
            boldHelp
        ));

        // while program run.
        while (continueProgram) {

            // Take input and push to factory buffer.
            userResponse = IOHandler.prompt(PROMPT_INDICATOR);
            Reader.pushToBuffer(userResponse);

            // while input not done.
            while (!Reader.inputIsDone()) {
                // take remaining on next line.
                IOHandler.printGapOnly();
                userResponse = IOHandler.prompt();
                Reader.pushToBuffer(userResponse);
            }

            // consumes the reader buffer and compare.
            if (Reader.consume().equalsIgnoreCase("exit;"))
                setContinueProgram(false);
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
