package fundb;

import fundb.repl.Repl;

public class Main {

    // Dedicated object for read, evaluate, print and loop stuff.
    private static Repl repl = new Repl();

    // Stores the user input when reading with `repl` reader.
    private static String userInput;

    public static void main(String[] args) {
        repl.printWelcome();

        while (repl.isLooping()) {
            // reads and execute.
            userInput = repl.read();
            repl.execute(userInput);
        }
    }
}
