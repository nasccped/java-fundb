package fundb.utils.strings;

// String repr concrete class (when some function / class requires `AsStringReprInterface`
// implementing).
public final class StringRepr implements AsStringReprInterface {

    // The inner string value.
    private String string;

    // Default constructor (same as `new String(...)`).
    public StringRepr(String value) {
        this.string = value;
    }

    // Works the same as `String.format` method.
    public static StringRepr format(String fmt, Object ... args) {
        return new StringRepr(String.format(fmt, args));
    }

    // Just returns the self `String`.
    public String asStringRepr() {
        return string;
    }
}
