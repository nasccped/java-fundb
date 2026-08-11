package fundb.utils.strings.colored;

// Refer to all basic ANSI color codes when coloring string. Each variant name holds it's specific
// base code value (value that refers to the color), but the coloring stuff is done at `AnsiEscape`
// logic implementation.
public enum ColorCode {
    // normal colors.
    BLACK(0),
    RED(1),
    GREEN(2),
    YELLOW(3),
    BLUE(4),
    MAGENTA(5),
    CYAN(6),
    WHITE(7),

    // bright colors.
    BRIGHT_BLACK(60),
    BRIGHT_RED(61),
    BRIGHT_GREEN(62),
    BRIGHT_YELLOW(63),
    BRIGHT_BLUE(64),
    BRIGHT_MAGENTA(65),
    BRIGHT_CYAN(66),
    BRIGHT_WHITE(67);

    // Holds the inner code value.
    private final int VALUE;

    ColorCode(int value) {
        this.VALUE = value;
    }

    // Returns the code associated with this value.
    protected int getValue() {
        return VALUE;
    }
}
