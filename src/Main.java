package fundb;

import java.util.HashMap;
import java.util.List;
import fundb.repl.Evaluator;
import fundb.repl.Printer;
import fundb.repl.Reader;
import fundb.token.TokenInterface;
import fundb.token.UndefinedTokenException;

// NOTE: temp - this is used for debug view. remove it latter.
import java.util.stream.Collectors;

public class Main {

    // Used prompt when asking for user.
    private static final String PROMPT_INDICATOR = "> ";

    // Variable to store the user response.
    private static String userResponse;

    // Variable used to check if the program should continue.
    private static boolean continueProgram = true;

    // Tokens returned from repl.Evaluator after input parsing.
    private static List<TokenInterface> tokens;

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

            // WARN: getTokensFromString can raise a runtime exception. This isn't a good approach
            //       but it allows an inner static that stores function pointer. This statement
            //       should be enclosed with try-catch technique.
            try {

                tokens = Evaluator.getTokensFromString(Reader.consume());

            } catch (UndefinedTokenException undefined) {
                // if fails, delegate to Printer and continue.
                Printer.reportResult(undefined);
                continue;
            }

            // NOTE: temp - debug view. remove it latter.
            IOHandler.println(String.join(
                " | ",
                tokens
                    .stream()
                    .map(tk -> tk.asDebugString())
                    .collect(Collectors.toList())
            ));

            // if exiting required.
            if (tokens.get(0).getInnerValue().equalsIgnoreCase("exit"))
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
