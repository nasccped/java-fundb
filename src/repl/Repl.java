package fundb.repl;

import fundb.repl.printer.Printer;

// Class responsible for repl (read, evaluate, print and loop) stuff.
public class Repl {

    // If the program is currently running.
    private boolean looping;

    // Does the printing to sysout.
    private Printer printer;

    public Repl() {
        this.looping = true;
        this.printer = new Printer();
    }

    // Prints a welcome message to sysout.
    public void printWelcome() {
        printer.printWelcome();
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
