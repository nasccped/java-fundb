package fundb.utils.strings.colored;

// Refers to the kind of style being applied to a `ColoredString` instance.
public enum StyleCode {
    BOLD(1),
    ITALIC(3),
    UNDERLINE(4);

    // Store the code value when a new instance is generated.
    private final int VALUE;

    StyleCode(int value) {
        this.VALUE = value;
    }

    // Return the inner value.
    protected int getValue() {
        return VALUE;
    }
}
