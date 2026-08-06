package fundb.tokens.kind;

// Refers to the kind of a token.
public enum TokenKind {
    // The current token is a command (`EXIT`, `HELP`, ...).
    COMMAND,

    // The current token is a query terminator (`;`).
    QUERY_TERMINATOR;

    // Returns token kind as user `String` view.
    public String getKindAsString() {
        return name().toLowerCase().replace("_", " ");
    }
}
