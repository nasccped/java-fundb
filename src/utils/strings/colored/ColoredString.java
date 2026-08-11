package fundb.utils.strings.colored;

import fundb.utils.strings.AsStringReprInterface;

// Refers to a colored string object. This class holds all the ANSI escape (as private) data to
// properly generete the colored output.
public class ColoredString implements AsStringReprInterface {

    // Holds the self inner `String`.
    private String selfString;

    // Refers to the escape data applied to the `String`.
    private AnsiEscape ansiEscape;

    public ColoredString(String s) {
        this.selfString = s;
        this.ansiEscape = new AnsiEscape();
    }

    // Set a new foreground color + returns the self `Object` reference. Note that once foreground
    // color is set, it can't be 'unset'. Instead, use this same method passing a `null` reference.
    public ColoredString withNewFgColor(ColorCode cc) {
        ansiEscape.setFg(cc);
        return this;
    }

    // Set a new background color + returns the self `Object` reference. Note that once background
    // color is set, it can't be 'unset'. Instead, use this same method passing a `null` reference.
    public ColoredString withNewBgColor(ColorCode cc) {
        ansiEscape.setBg(cc);
        return this;
    }

    // Add a new style (bold, italic, ...) to the style set.
    public ColoredString withStyle(StyleCode ... styles) {
        for (StyleCode sc : styles) {
            if (sc != null)
                ansiEscape.addStyle(sc);
        }
        return this;
    }

    public String asStringRepr() {
        return String.format(
            "%s%s%s",
            ansiEscape.asStringRepr(),
            selfString,
            AnsiEscape.getResetEscapeString()
        );
    }
}
