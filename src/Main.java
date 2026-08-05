package fundb;

import fundb.database.result.AbstractExecutionResult;
import fundb.repl.Repl;
import fundb.token.TokenSequence;

public class Main {

    // Dedicated object for read, evaluate, print and loop stuff.
    private static Repl repl = new Repl();

    // Stores the user input when reading with `repl` reader.
    private static String userInput;

    // Token sequence from an evaluated `String` input.
    private static TokenSequence evaluation;

    // Result obtained after database manager execution.
    private static AbstractExecutionResult exeResult;

    public static void main(String[] args) {
        repl.printWelcome();

        while (repl.isLooping()) {
            userInput = repl.read();

            // try to:
            try {
                // evaluate input and execute
                evaluation = repl.evaluate(userInput);
                exeResult = repl.execute(evaluation);

            } catch (ReportableResultInterface e) {
                // if fail (safe since all exceptions should be reportable)
                repl.reportResult(e);
                continue;
            }

            // if succeeds, report
            repl.reportResult(exeResult);
        }
    }
}
