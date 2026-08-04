package fundb.repl.reader;

import java.util.Scanner;

// Reads the user input from sysin.
public class Reader {

    // Scanner for input reading.
    private final Scanner SC;

    public Reader() {
        this.SC = new Scanner(System.in);
    }

    // Reads the user input from sysin.
    public String read() {
        return SC.nextLine();
    }
}
