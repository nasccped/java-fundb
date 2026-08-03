package fundb.repl;

// Class responsible for repl (read, evaluate, print and loop) stuff.
//
// This class exposes all the necessary methods for dealing with input/output work, but the
// `iohandler` package holds the std(io) implementations.
public class Repl {

    public Repl() {}

    // Prints the welcome message at sysout.
    public void printWelcome() {
        System.out.println("Welcome, user!");
    }

}
