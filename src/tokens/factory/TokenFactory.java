package fundb.tokens.factory;

import fundb.regex.RegexHelper;
import fundb.tokens.definition.TokenDefinition;
import fundb.tokens.variants.AbstractToken;
import fundb.tokens.variants.CommandToken;
import fundb.tokens.variants.QueryTerminatorToken;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Can build up a token from String. This class holds (statically) the logic for `String` to
// `TokenInterface` convertion.
public class TokenFactory {

    // Build all available `TokenDefinition`s.
    private static final TokenDefinition<? extends AbstractToken>[] TOKEN_DEFINITIONS =
    new TokenDefinition<?>[]{
        new TokenDefinition<>(CommandToken.class, new RegexHelper("cmd", "exit|help")),
        new TokenDefinition<>(QueryTerminatorToken.class, new RegexHelper("qterm", ";"))
    };

    // Means a global regex pattern for all kind of tokens matching.
    private static final Pattern TOKENS_REGEX_PATTERN = Pattern.compile(
        // String regex pattern.
        Arrays

            // for each token definition
            .stream(TOKEN_DEFINITIONS)
            .map(td -> {

                // get the regex helper
                RegexHelper rh = td.getRegexHelper();

                // and map it to a single regex group.
                return String.format(
                    "(?<%s>%s)",
                    rh.getRegexGroupName(),
                    rh.getRegexGroupPattern()
                );

            }).collect(Collectors.joining("|")), // collect they all with regex `OR` operator.

        // `SQL` case doesn't matter.
        Pattern.CASE_INSENSITIVE
    );

    // Returns the private regex pattern for all recognized tokens.
    public static Pattern getTokensRegexPattern() {
        return TOKENS_REGEX_PATTERN;
    }

    // Returns an specific `AbstractToken` extender from a given s `String`.
    public static AbstractToken getTokenFromString(String s) {
        // TODO: implement it.
        throw new UnsupportedOperationException("`TokenFactory::getTokenFromString` funtion isn't implemented yet");
    }
}
