package fundb.repl.reader;

import fundb.repl.printer.Printer;
import java.util.Scanner;

// Reads the user input from sysin.
public class Reader {

    // Scanner for input reading.
    private final Scanner SC;

    // Printer for read after prompt.
    private final Printer PRINTER;

    // Indicator for prompt.
    private final String PROMPT_INDICATOR;

    public Reader(Printer printer) {
        this.SC = new Scanner(System.in);
        this.PRINTER = printer;
        this.PROMPT_INDICATOR = "\u001b[95mfundb $ \u001b[0m";
    }

    // Reads the user input from sysin.
    public String read() {
        PRINTER.print(PROMPT_INDICATOR);
        return SC.nextLine();
    }
}
