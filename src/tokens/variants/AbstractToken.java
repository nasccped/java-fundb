package fundb.tokens.variants;

import fundb.tokens.kind.TokenKind;

// Refers to an abstract shape of token. This class provides token methods defaults.
//
// NOTE: 1. `this.setTokenKind` method should be used at extenders constructors since getter
//          methods calls `checkReferenceNullability` which can throws an
//          `UnsupportedOperationException`.
//       2. `TOKEN_VALUE` also can't be null since it triggers the `checkReferenceNullability` on
//          `getTokenValue` method call.
public abstract class AbstractToken {

    // Refers to the inner value carried by this token.
    private final String TOKEN_VALUE;

    // Refers to the kind carried by the current token.
    private TokenKind tokenKind;

    // Creates a new AbstractToken instance.
    //
    // NOTE: `tokenKind` is `null` by default. Update it by using the `setTokenKind` within the
    //       extender class.
    protected AbstractToken(String value) {
        this.TOKEN_VALUE = value;
        this.tokenKind = null;
    }

    // Set a new kind for the current token.
    protected final void setTokenKind(TokenKind kind) {
        tokenKind = kind;
    }

    // Checks if the passed object reference points to `null` object (throwing an
    // `UnsupportedOperationException` if so).
    private final void checkReferenceNullability(String objName, Object objRef) {
        if (objRef == null) {
            throw new UnsupportedOperationException(String.format(
                "`%s` Object reference points to null (at `%s` class). %s",
                objName,
                getClass().getSimpleName(),
                "Reads AbstractToken docstring"
            ));
        }
    }

    // Returns the kind of token for the current class. Can throw `UnsupportedOperationException`
    // if `tokenKind` refering to `null`.
    public final TokenKind getTokenKind() {
        checkReferenceNullability("tokenKind", tokenKind);
        return tokenKind;
    }

    // Returns the inner value held by this token. Can throw `UnsupportedOperationException`
    // if `tokenKind` refering to `null`.
    public final String getTokenValue() {
        checkReferenceNullability("TOKEN_VALUE", TOKEN_VALUE);
        return TOKEN_VALUE;
    }
}
