package fundb.tokens;

import fundb.tokens.variants.AbstractToken;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Optional;

// Represents a sequence of tokens.
public class TokenSequence {

    // All tokens stored by this token sequence.
    private Deque<AbstractToken> tokens;

    public TokenSequence(Collection<AbstractToken> c) {
        this.tokens = new ArrayDeque<>(tokens);
    }

    // Consumes the first token on the sequence (returns `Optional` of `null` if empty).
    public Optional<AbstractToken> consumeFirst() {
        return Optional.ofNullable(tokens.pollFirst());
    }
}
