package fundb.repl;

import fundb.repl.printer.Printer;

// Class responsible for repl (read, evaluate, print and loop) stuff.
public class Repl {

    // Does the printing to sysout.
    private Printer printer;

    public Repl() {
        this.printer = new Printer();
    }

    // Prints a welcome message to sysout.
    public void printWelcome() {
        printer.printWelcome();
    }

}
