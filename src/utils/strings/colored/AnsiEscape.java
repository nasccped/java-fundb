package fundb.utils.strings.colored;

import fundb.utils.strings.AsStringReprInterface;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

// Does all the code formating logic.
class AnsiEscape implements AsStringReprInterface {

    // Default escape when reseting.
    private static final String RESET_ESCAPE_STRING = "\u001b[0m";

    // Minimal value that should be added to `ColorCode` inner value when trying to get the
    // foreground color code.
    private static final int MINIMAL_FG_COLOR_CODE_VALUE = 30;

    // Minimal value that should be added to `ColorCode` inner value when trying to get the
    // background color code.
    private static final int MINIMAL_BG_COLOR_CODE_VALUE = 40;

    // Refers to an optional foreground color code.
    private Optional<ColorCode> fgColorCode;

    // Refers to an optional background color code.
    private Optional<ColorCode> bgColorCode;

    // Refers to a set off style codes (since more than 1 can be set at same time).
    private HashSet<StyleCode> styleCodes;

    protected AnsiEscape() {
        this.fgColorCode = Optional.empty();
        this.bgColorCode = Optional.empty();
        this.styleCodes = new HashSet<>();
    }

    // Add a new style to the style set.
    protected void addStyle(StyleCode sc) {
        styleCodes.add(sc);
    }

    // Set a new foreground color.
    protected void setFg(ColorCode cc) {
        fgColorCode = Optional.of(cc);
    }

    // Set a new background color.
    protected void setBg(ColorCode cc) {
        bgColorCode = Optional.of(cc);
    }

    // Returns the reset escape.
    protected static String getResetEscapeString() {
        return RESET_ESCAPE_STRING;
    }

    // Converts the object data into a single escape.
    public String asStringRepr() {
        LinkedList<Integer> codesList = new LinkedList<>();

        for (StyleCode sc : styleCodes)
            codesList.add(sc.getValue());

        fgColorCode.ifPresent(c -> codesList.add(c.getValue() + MINIMAL_FG_COLOR_CODE_VALUE));
        bgColorCode.ifPresent(c -> codesList.add(c.getValue() + MINIMAL_BG_COLOR_CODE_VALUE));

        if (codesList.isEmpty())
            return "";

        return String.format(
            "\u001b[%sm",
            codesList.stream().map(value -> String.valueOf(value)).collect(Collectors.joining(";"))
        );
    }
}
