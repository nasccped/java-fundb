package fundb.repl.evaluator;

import fundb.tokens.factory.TokenFactory;
import fundb.tokens.TokenSequence;
import fundb.tokens.variants.AbstractToken;
import fundb.utils.exceptions.evaluation.replparse.AbstractEvaluationException;
import fundb.utils.exceptions.evaluation.replparse.EmptyQueryException;
import fundb.utils.exceptions.evaluation.replparse.UncoveredSubstringException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class is responsible for converting String input into a `TokenSequence` object.
public class Evaluator {

    // Regex pattern used to match all different tokens from the user input.
    private final Pattern TOKENS_REGEX;

    // Refers to a non-whitespace pattern matcher (when dealing with uncovered substrings).
    private final Pattern NON_WHITESPACE_PATTERN;

    public Evaluator() {
        this.TOKENS_REGEX = TokenFactory.getTokensRegexPattern();
        this.NON_WHITESPACE_PATTERN = Pattern.compile("\\S+");
    }

    // Takes a `String` input and evaluates it to a `TokenSequence`. Can throws
    // `EvaluationException` if some non-empty `String` not covered (tokenized).
    public TokenSequence evaluate(String input) throws AbstractEvaluationException {
        // substring between covered tokens.
        String tempSubstring;

        // auxiliar integers:
        int
            previousCover = 0, // char index of latest COVERED substring (exclusive).
            substringBegin = 0, // begin index of the `tempSubstring`.
            substringEnd = 0, // end index of the `tempSubstring` (exclusive).
            uncoveredSubstringsCount = 0; // How many substring (non-empty) haven't been covered.

        Matcher matcher = TOKENS_REGEX.matcher(input);
        Deque<AbstractToken> tokens = new ArrayDeque<>();
        AbstractToken currentToken;
        UncoveredSubstringException mayExcept = null;

        while (matcher.find()) {
            currentToken = TokenFactory.getTokenFromString(matcher.group());
            tokens.add(currentToken);

            substringBegin = previousCover;
            substringEnd = matcher.start();
            tempSubstring = input.substring(substringBegin, substringEnd);

            mayExcept = mayUpdateUncovSubsExc(
                mayExcept,
                tempSubstring,
                substringBegin,
                substringEnd
            );
            previousCover = matcher.end();
        }

        substringBegin = previousCover;
        substringEnd = input.length();
        tempSubstring = input.substring(substringBegin, substringEnd);

        mayExcept = mayUpdateUncovSubsExc(
            mayExcept,
            tempSubstring,
            substringBegin,
            substringEnd
        );

        // If uncovered substring exception is some.
        if (mayExcept != null)
            throw mayExcept;

        // else if empty tokens (null uncovered substring means empty query).
        else if (tokens.size() == 0)
            throw new EmptyQueryException();

        return new TokenSequence(tokens);
    }

    // May update the `UncoveredSubstringException` passed as argument by the provided substring.
    // Note that this function doesn't actually checks substring validity (since it's expected to
    // be done at caller's function). This funciton also returns an `UncoveredSubstringException`
    // (same reference as `exc` param) so it not loses the original reference.
    private UncoveredSubstringException mayUpdateUncovSubsExc(
        UncoveredSubstringException exc,
        String substring,
        int beginIndex,
        int endIndex
    ) {
        Matcher matcher = NON_WHITESPACE_PATTERN.matcher(substring);

        while (matcher.find()) {
            if (exc == null)
                exc = new UncoveredSubstringException(
                    matcher.group(),
                    beginIndex + matcher.start(),
                    beginIndex + matcher.end()
                );
            else
                exc.increment();
        }

        return exc;
    }
}
