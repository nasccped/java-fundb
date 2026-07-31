package repl;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// This class is responsible for converting String input into a Token list.
public class Evaluator {

    // Mapping used between group names and regex patterns.
    private static final Map<String, String[]> regexGroupMapping = Map.ofEntries(
        Map.entry("cmd", new String[]{"exit", "help"}),
        Map.entry("semicolon", new String[]{"\\;"})
    );

    // Regex pattern used to group the String token (refers to `getTokensFromString` function).
    private static final Pattern regexPattern;

    // build the regex pattern statically.
    static {
        String pat = regexGroupMapping
            .entrySet()
            .stream()
            .map(entry -> String.format(
                "(?<%s>%s)",
                entry.getKey(),
                String.join("|", entry.getValue())
            )).collect(Collectors.joining("|"));

        regexPattern = Pattern.compile(
            pat,
            Pattern.CASE_INSENSITIVE
        );
    }

    // Reads a s `String` and returns the Tokens from it.
    public static List<String> getTokensFromString(String s) {
        // TODO: add real token returning instead of single string.
        LinkedList<String> ll = new LinkedList<>();
        Matcher m = regexPattern.matcher(s);

        // for each match
        while (m.find())
            ll.add(m.group());

        // return it.
        return ll;
    }
}
