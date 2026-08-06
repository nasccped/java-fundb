package fundb.tokens.definition;

import fundb.tokens.variants.AbstractToken;
import fundb.regex.RegexHelper;

// Token definition: associates an `AbstractToken` class variant with a `RegexHelper` building
// a different regex pattern for all diferent kinds of tokens.
public record TokenDefinition<C extends AbstractToken>(Class<C> variant, RegexHelper rh) {

    // Returns the `Class<?>` variant of the self token definition.
    public Class<C> getVariant() {
        return variant;
    }

    // Returns the `RegexHelper` of the self token definition.
    public RegexHelper getRegexHelper() {
        return rh;
    }
}
