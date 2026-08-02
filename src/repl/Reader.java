package fundb.repl;

import java.util.Stack;

// The stdin reading buffer impl.
public class Reader {

    // Expected character when an open block is initialized.
    private enum OpenCloseChar {

        // When opening a block with '{'.
        CURLY_BRACKETS,

        // When opening a block with '"'.
        DOUBLE_QUOTE,

        // When opening a block with '('.
        PARENTHESES,

        // When doing a new query (non terminating ';').
        SEMI_COLON,

        // When opening a block with '''.
        SINGLE_QUOTE
    }

    // Inner buffer for stdin storing.
    private static StringBuffer buffer = new StringBuffer();

    // Stack for expected closing char (mentioned at `OpenCloseChar` definition).
    private static Stack<OpenCloseChar> expecting = new Stack<>();

    // Pushes the s `String` to the inner StringBuffer. Note that this function doesn't push the
    // entire `String`, but just the 'necessary' chars (non-whitespace).
    public static void pushToBuffer(String s) {
        // temp store the expected closing char.
        OpenCloseChar expect;

        // for each char in our s String.
        for (char c : s.toCharArray()) {

            // if pushing isn't necessary (empty char in non-string input slice), continue to next.
            if (!shouldBeAddedToBuffer(c))
                continue;

            // if is a trailing new query.
            else if (isNewQueryCall(c)) {
                // expect semi colon.
                expecting.push(OpenCloseChar.SEMI_COLON);

                // if cur char refers to opening block
                if ((expect = openCharFromChar(c)) != null)
                    expecting.push(expect);

                // add cur char to buffer.
                buffer.append(c);

                // if not new query (still the previous one).
            } else {
                // pop if necessary.
                if (isClosingTheExpectedChar(c))
                    expecting.pop();

                // push to buffer.
                buffer.append(c);
            }
        }

        // if query not ended (push new line considering string literal case).
        if (!inputIsDone())
            buffer.append('\n');
    }

    // Returns if the input storing is done (no queries remaining).
    public static boolean inputIsDone() {
        return expecting.empty();
    }

    // Takes the inner buffer data, consume inner value as String, reset the buffer and returns the
    // final String.
    public static String consume() {
        String s = buffer.toString();
        buffer.setLength(0);
        return s;
    }

    // Checks if the provided char refers to a new query (like compound queries).
    private static boolean isNewQueryCall(char c) {
        return c != ' ' && expecting.empty();
    }

    // Returns the expected Character at the top of Stack (or null if empty).
    private static OpenCloseChar expectedCharOrNull() {
        return expecting.empty() ? null : expecting.peek();
    }

    // Returns if the c character should be added to the input buffer (based on stack inner state).
    private static boolean shouldBeAddedToBuffer(char c) {
        OpenCloseChar exp = expectedCharOrNull();
        return c != ' '
            || (exp == OpenCloseChar.SINGLE_QUOTE || exp == OpenCloseChar.DOUBLE_QUOTE);
    }

    // Returns the OpenCloseChar char at the top of expecting stack (null if empty).
    private static OpenCloseChar openCloseCharOrNull() {
        return expecting.empty() ? null : expecting.peek();
    }

    // Returns a new `OpenCloseChar` variant from a given c char. This can also returns null if c
    // is recognized as simple char (or not in opening context).
    private static OpenCloseChar openCharFromChar(char c) {
        OpenCloseChar onTop;
        switch (c) {
            case '\'':
                onTop = openCloseCharOrNull();
                // if char should be CLOSING single quote.
                return (onTop == OpenCloseChar.SINGLE_QUOTE) ? null
                    : OpenCloseChar.SINGLE_QUOTE;

            case '"':
                onTop = openCloseCharOrNull();
                // if char should be CLOSING double quote.
                return (onTop == OpenCloseChar.DOUBLE_QUOTE) ? null
                    : OpenCloseChar.DOUBLE_QUOTE;

            case '{':
                onTop = openCloseCharOrNull();

                // if on top is single quote (within string)
                return (onTop == OpenCloseChar.SINGLE_QUOTE) ? null

                    // if on top is double quote (within string)
                    : (onTop == OpenCloseChar.DOUBLE_QUOTE) ? null

                    // otherwise:
                    : OpenCloseChar.CURLY_BRACKETS;

            case '(':
                onTop = openCloseCharOrNull();

                // if on top is single quote (within string)
                return (onTop == OpenCloseChar.SINGLE_QUOTE) ? null

                    // if on top is double quote (within string)
                    : (onTop == OpenCloseChar.DOUBLE_QUOTE) ? null

                    // otherwise:
                    : OpenCloseChar.PARENTHESES;

            default:
                return null;
        }
    }

    // Returns if the given c `char` closes the the expected char at stack.
    private static boolean isClosingTheExpectedChar(char c) {
        switch (openCloseCharOrNull()) {
            case OpenCloseChar.SINGLE_QUOTE:
                return c == '\'';

            case OpenCloseChar.DOUBLE_QUOTE:
                return c == '"';

            case OpenCloseChar.CURLY_BRACKETS:
                return c == '}';

            case OpenCloseChar.SEMI_COLON:
                return c == ';';

            case OpenCloseChar.PARENTHESES:
                return c == ')';

            case null:
                return false;
        }
    }
}
