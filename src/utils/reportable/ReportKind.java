package fundb.utils.reportable;

import fundb.utils.strings.AsStringReprInterface;
import fundb.utils.strings.colored.ColorCode;
import fundb.utils.strings.colored.ColoredString;
import fundb.utils.strings.colored.StyleCode;
import java.util.HashMap;

// Refers to the kind of report being done (mainly used to print the result tag, like:
// "WARN -> operation done but...").
public enum ReportKind implements AsStringReprInterface {

    // When everything was done well.
    DONE,

    // When some fail occurs.
    FAIL,

    // When stuff is done but warnings are generated.
    WARN,

    // Anonymous report (not important).
    ANON;

    // Map each kind to a background `ColorCode`.
    private static final HashMap<ReportKind, ColorCode> KIND_TO_COLOR_MAP = new HashMap<>();

    static {
        KIND_TO_COLOR_MAP.put(ReportKind.DONE, ColorCode.BLUE);
        KIND_TO_COLOR_MAP.put(ReportKind.WARN, ColorCode.YELLOW);
        KIND_TO_COLOR_MAP.put(ReportKind.FAIL, ColorCode.RED);
    }

    // Inner value (as `String`).
    private String kindAsString;

    // Any non-anonymous kind is representable.
    public boolean isKindRepresentable() {
        return this != ANON;
    }

    // Returns the kind length (after string conversion string).
    public int getStringLength() {
        initKindAsStringIfNecessary();
        return kindAsString.length();
    }

    // Returns the report kind as `String` representing (user view).
    public String asStringRepr() {
        if (this == ANON)
            throw new UnsupportedOperationException(String.format(
                "%s. %s",
                "Calling `asStringRepr` on `ReportKind.ANON` isn't allowed",
                "Call `isKindRepresentable` before to check if it should (or not) be print"
            ));

        initKindAsStringIfNecessary();

        return new ColoredString(kindAsString)
            .withStyle(StyleCode.BOLD)
            .withNewFgColor(ColorCode.BRIGHT_WHITE)
            .withNewBgColor(KIND_TO_COLOR_MAP.getOrDefault(this, ColorCode.BRIGHT_BLACK))
            .asStringRepr();
    }

    // Only sets the `kindAsString` if necessary (null or empty).
    private void initKindAsStringIfNecessary() {
        if (kindAsString == null || kindAsString.isEmpty())
            kindAsString = String.format(" %s ", name());
    }
}
