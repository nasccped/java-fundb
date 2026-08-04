package fundb.repl;

import fundb.repl.printer.Printer;
import fundb.repl.reader.Reader;

// Class responsible for repl (read, evaluate, print and loop) stuff.
public class Repl {

    // If the program is currently running.
    private boolean looping;

    // Does the printing to sysout.
    private Printer printer;

    // Does the reading from sysin.
    private Reader reader;

    public Repl() {
        this.looping = true;
        this.printer = new Printer();
        this.reader = new Reader();
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

    // Returns if the program is currently running.
    public boolean isLooping() {
        return looping;
    }

    // Turns the program off by set looping to `false`.
    public void terminate() {
        looping = false;
    }
}
