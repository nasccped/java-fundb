package fundb.repl;

import fundb.database.DatabaseManager;
import fundb.repl.printer.Printer;
import fundb.repl.reader.Reader;
import fundb.repl.evaluator.Evaluator;
import fundb.repl.evaluator.EvaluationException;
import fundb.tokens.TokenSequence;

// Class responsible for repl (read, evaluate, print and loop) stuff.
public class Repl {

    // If the program is currently running.
    private boolean looping;

    // Does the printing to sysout.
    private Printer printer;

    // Does the reading from sysin.
    private Reader reader;

    // Database manager for query execution.
    private DatabaseManager man;

    // User input evaluator dedicated object.
    private Evaluator evaluator;

    public Repl() {
        this.looping = true;
        this.printer = new Printer();
        this.reader = new Reader();
        this.man = new DatabaseManager(this);
        this.evaluator = new Evaluator();
    }

    // Prints a welcome message to sysout.
    public void printWelcome() {
        printer.println("This is java-fundb, a repl database made with love!");
        printer.println("Consider using 'exit;' or 'help;' at any time.");
    }

    // Reads the user input (sysin).
    public String read() {
        return reader.read();
    }

    // Tries to evaluate a given `String` input. Throws `EvaluationException` on fails.
    public TokenSequence evaluate(String input) throws EvaluationException {
        return evaluator.evaluate(input);
    }

    // Passes the token sequence to database manager and returns it's result as an interface (or
    // throws `AbstractDatabaseExecutionException` if fails).
    public ReportableResultInterface execute(TokenSequence ts) throws AbstractExecutionException {
        return man.execute(ts);
    }

    // Reports the final result to the user throug sysout.
    public <R extends ReportableResultInterface> void reportResult(R result) {
        throw new UnsupportedOperationException("TODO: implemente reportResult function.");
    }

    // Returns if the program is currently running.
    public boolean isLooping() {
        return looping;
    }

    // Turns the program off by set looping to `false`.
    public void terminate() {
        looping = false;
    }
}
