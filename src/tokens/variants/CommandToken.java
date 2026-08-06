package fundb.tokens.variants;

import fundb.tokens.kind.TokenKind;

// Refers to all tokens recognized as commands (`EXIT`, `CREATE`, ...).
public class CommandToken extends AbstractToken {

    public CommandToken(String cmd) {
        super(cmd.toUpperCase());
        this.setTokenKind(TokenKind.COMMAND);
    }
}
