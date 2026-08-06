package fundb.repl.evaluator;

import fundb.tokens.factory.TokenFactory;
import fundb.tokens.TokenSequence;
import fundb.tokens.variants.AbstractToken;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class is responsible for converting String input into a `TokenSequence` object.
public class Evaluator {

    // Regex pattern used to match all different tokens from the user input.
    private final Pattern REGEX_PATTERN;

    public Evaluator() {
        this.REGEX_PATTERN = TokenFactory.getTokensRegexPattern();
    }

    // Takes a `String` input and evaluates it to a `TokenSequence`. Can throws
    // `EvaluationException` if some non-empty `String` not covered (tokenized).
    public TokenSequence evaluate(String input) throws EvaluationException {
        Matcher matcher = REGEX_PATTERN.matcher(input);
        Deque<AbstractToken> tokens = new ArrayDeque<>();

        while (matcher.find())
            tokens.add(TokenFactory.getTokenFromString(matcher.group()));

        return new TokenSequence(tokens);
    }
}
