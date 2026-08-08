package fundb.utils.reportable;

import fundb.utils.strings.AsStringReprInterface;

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
        return kindAsString;
    }

    // Only sets the `kindAsString` if necessary (null or empty).
    private void initKindAsStringIfNecessary() {
        if (kindAsString == null || kindAsString.isEmpty())
            kindAsString = String.format(" %s ", name());
    }
}
