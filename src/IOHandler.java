// Handles the terminal input / output data.
class IOHandler {

    // String placeholder used to generate the the left gap when printing to stdout.
    private static final String gapPlaceholder = " ";

    // Gap distance from the terminal's left border when printing to stdout.
    private static int leftGap = 0;

    // If the gap spacing should be print (turned off when using print function).
    private static boolean printGap = true;

    // Prints the left gap spacing (if needed) + obj content to the stdout with a new line at the
    // end.
    protected static void println(Object obj) {
        System.out.println(getLeftGapString() + obj);
        printGap = true;
    }

    // Just prints an empty line to stdout.
    protected static void println() {
        System.out.println();
        printGap = true;
    }

    // Prints the left gap spacing (if needed) + obj content to the stdout without a new line at
    // the end.
    protected static void print(Object obj) {
        System.out.print(getLeftGapString() + obj);
        printGap = false;
    }

    // Set a new value to the inner left gap field. This function can throw an
    // `InvalidArgumentException` if passed value is negative.
    protected static void setLeftGap(int value) {
        if (value < 0)
            throw new IllegalArgumentException(
                String.format("setLeftGap function expects a zero/positive integer, not %d", value)
            );
        leftGap = value;
    }

    // Returns the left gap as String. Better than using private attributes since it actually
    // calculates the string length.
    private static String getLeftGapString() {
        return gapPlaceholder.repeat(printGap ? leftGap : 0);
    }
}
