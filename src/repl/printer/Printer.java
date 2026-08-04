package fundb.repl.printer;

// Dedicated class for content printing.
public class Printer {

    public Printer() {}

    // Prints the object item with a newline at the end.
    public void println(Object obj) {
        System.out.println(obj);
    }

    // Prints an empty line (+ newline at the end).
    public void println() {
        System.out.println();
    }

    // Prints the object item WITHOUT a newline at the end.
    public void print(Object obj) {
        System.out.print(obj);
    }

    // Prints a welcome message to sysout.
    public void printWelcome() {
        println("This is java-fundb and you're very welcome!");
    }
}
