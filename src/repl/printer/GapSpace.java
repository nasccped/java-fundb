package fundb.repl.printer;

// Means the left gap spacing when using printer.
class GapSpace {

    // Gap space value.
    private int gap;

    protected GapSpace() {
        this.gap = 0;
    }

    // Set a new value as gap (throws `IllegalArgumentException` if negative).
    protected void setGap(int newGap) {
        if (newGap < 0) {
            throw new IllegalArgumentException(
                "`newGap` must be equal or greater than 0. Negative spacing not allowed"
            );
        }
        gap = newGap;
    }

    // Returns the inner gap value.
    protected int getGap() {
        return gap;
    }
}
