package fundb.regex;

// Auxiliar class for regex string handling.
public class RegexHelper {

    // Name refering to this group.
    private final String regexGroupName;

    // Regex pattern refering to this group.
    private final String regexGroupPattern;

    public RegexHelper(String regexGroupName, String regexGroupPattern) {
        this.regexGroupName = regexGroupName;
        this.regexGroupPattern = regexGroupPattern;
    }

    // Returns the regex group name.
    public String getRegexGroupName() {
        return regexGroupName;
    }

    // Returns the regex group pattern.
    public String getRegexGroupPattern() {
        return regexGroupPattern;
    }
}
