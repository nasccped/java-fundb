package fundb;

import fundb.repl.Repl;

public class Main {

    // Dedicated object for read, evaluate, print and loop stuff.
    private static Repl repl = new Repl();

    public static void main(String[] args) {
        // Prints the welcome message to the user through sysout.
        repl.printWelcome();
    }
}
