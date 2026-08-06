package fundb.tokens.variants;

import fundb.tokens.kind.TokenKind;

// Refers to the token recognized as query terminator (`;`).
public class QueryTerminatorToken extends AbstractToken {

    // WARN: This constructor requires taking a `String` reference (even when token refering to a
    //       single semicolon) since `TokenFactory` can't detected which `AbstractToken` is being
    //       constructed on regex matching iteration.
    public QueryTerminatorToken(String s) {
        super(";");
        this.setTokenKind(TokenKind.QUERY_TERMINATOR);
    }
}
