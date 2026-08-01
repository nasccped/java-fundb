package fundb.token;

import java.util.function.Function;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import fundb.regexing.RegexRecord;

// Can build up a token from String. This class holds (statically) the logic for `String` to
// `TokenInterface` convertion.
public class TokenFactory {

    // Record pair for a regex record (refers to `RegexRecord`) and a function converter (refers to
    // `Function<String, TokenInterface>`, a function that takes a `String` and converts it into a
    // token - similar to C's function pointer).
    private record RegexAndConverter(
        RegexRecord regexRecord,
        Function<String, TokenInterface> convert
    ) {}

    // All regex-convert pairs disposed by this factory. Since this list is used whithin the
    // `newToken()` public method, the order DEFINITELY matters. Priority tokens come first (such
    // as string literals), less prio latter (`UndefinedTokenException`).
    private static final List<RegexAndConverter> regexAndConverter = List.of(
        new RegexAndConverter(CommandToken.getRegexRecord(), TokenFactory::newCommand),
        new RegexAndConverter(SemicolonToken.getRegexRecord(), TokenFactory::newSemicolon),

        // Instance bellow is inportant, consider reading the `newUndefinedToken()` function doc.
        new RegexAndConverter(
            UndefinedTokenException.getRegexRecord(),
            TokenFactory::newUndefinedToken
        )
    );

    // Returns only the regex record of the `regexAndConverter` field.
    public static List<RegexRecord> getRegexRecordList() {
        return regexAndConverter
            .stream()
            .map(reCt -> reCt.regexRecord)
            .collect(Collectors.toList());
    }

    // Generates a new token from a given s `String`. This function creates a pattern and matcher
    // for each `RegexRecord` at `regexAndConverter` field. If it matches, returns the token
    // generated from the corresponding function pointer (can raise `UndefinedTokenException`).
    public static TokenInterface newToken(String s) throws UndefinedTokenException {
        Pattern pattern;
        Matcher matcher;

        // for each available regex and convert
        for (RegexAndConverter reCt : regexAndConverter) {
            pattern = Pattern.compile(reCt.regexRecord.getPattern(), Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(s);

            // if matches
            if (matcher.matches())
                return reCt.convert.apply(s);
        }

        // no matching found.
        throw new UndefinedTokenException(s);
    }

    // Creates a new `CommandToken` from the s `String`.
    private static CommandToken newCommand(String s) {
        return new CommandToken(s);
    }

    // Creates a new `SemicolonToken` from the s `String`.
    private static SemicolonToken newSemicolon(String s) {
        return new SemicolonToken();
    }

    // NOTE: this function will raise an `UndefinedTokenException` (on purpose). It means that the
    //       passed `String` doesn't match to any recognized token, but the `regexAndConverter`
    //       field can only store functions that doesn't raise `Exception`. That's the reason that
    //       `UndefinedTokenException` extends `RuntimeException` instead of `Exception`.
    private static TokenInterface newUndefinedToken(String s) throws UndefinedTokenException {
        throw new UndefinedTokenException(s);
    }
}
