package fundb.repl;

import java.util.List;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import fundb.token.TokenInterface;
import fundb.token.TokenFactory;
import fundb.token.UndefinedTokenException;

// This class is responsible for converting String input into a Token list.
public class Evaluator {

    // Regex pattern used to match all different tokens from the user input.
    private static final Pattern regexPattern = Pattern.compile(
        TokenFactory
            .getRegexRecordList()
            .stream()
            .map(rr -> String.format("(?<%s>%s)", rr.getGroup(), rr.getPattern()))
            .collect(Collectors.joining("|")),
        Pattern.CASE_INSENSITIVE
    );

    // Matcher storer for user input against regex.
    private static Matcher inputMacther;

    // Stores the generate token list. Is reset whenever `Evaluator.getTokensFromString()` method
    // is called.
    private static LinkedList<TokenInterface> tokenList;

    // Reads a s `String` and returns the Tokens list from it. This function can raise an
    // `UndefinedTokenException` (which is raise at `TokenFactory.newToken()` method, actually).
    // This occurs when the provided `String` doesn't match to any recognized regex `Pattern`.
    public static List<TokenInterface> getTokensFromString(String s)
    throws UndefinedTokenException {
        // init list and matcher for s string.
        tokenList = new LinkedList<>();
        inputMacther = regexPattern.matcher(s);

        // for all matched groups.
        while (inputMacther.find())
            tokenList.add(TokenFactory.newToken(inputMacther.group()));

        // return token list.
        return tokenList;
    }
}
