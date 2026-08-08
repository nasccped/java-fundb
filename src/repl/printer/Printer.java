package fundb.repl.printer;

// Dedicated class for content printing.
public class Printer {

    // Refers to the gap spacing when printing content.
    private GapSpace gapSpace;

    // check if line being print is a new one (helps to print - OR NOT - the gap spacing).
    private boolean isNewLine;

    public Printer() {
        this.gapSpace = new GapSpace();
        this.isNewLine = true;
    }

    // Prints the object item with a newline at the end + reset new the `isNewLine` trigger.
    public void println(Object obj) {
        System.out.println(String.format("%s%s", getGapSpacingString(), String.valueOf(obj)));
        isNewLine = true;
    }

    // Prints an empty line (+ reset new the `isNewLine` trigger).
    public void println() {
        System.out.println(getGapSpacingString());
        isNewLine = true;
    }

    // Prints the object item WITHOUT a newline at the end (+ set `isNewLine` trigger to false).
    public void print(Object obj) {
        System.out.print(String.format("%s%s", getGapSpacingString(), String.valueOf(obj)));
        isNewLine = false;
    }

    // Set a new value for gap spacing. Throws `IllegalArgumentException` if negative.
    public void setLeftGap(int value) {
        gapSpace.setGap(value);
    }

    // Returns the gap spacing inner value.
    public int getLeftGap() {
        return gapSpace.getGap();
    }

    // Returns the gap spacing as string.
    private String getGapSpacingString() {
        return isNewLine ? " ".repeat(gapSpace.getGap()) : "";
    }
}
