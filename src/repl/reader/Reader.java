package fundb.repl.reader;

import fundb.repl.printer.Printer;
import fundb.utils.strings.colored.ColorCode;
import fundb.utils.strings.colored.ColoredString;
import fundb.utils.strings.colored.StyleCode;
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
        this.PROMPT_INDICATOR = new ColoredString("fundb $ ")
            .withStyle(StyleCode.BOLD)
            .withNewFgColor(ColorCode.BRIGHT_GREEN)
            .asStringRepr();
    }

    // Reads the user input from sysin.
    public String read() {
        PRINTER.print(PROMPT_INDICATOR);
        return SC.nextLine();
    }
}
