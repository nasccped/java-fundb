package fundb.utils.strings;

// An interface that allow object representation (works similar to `toString` method, but
// it provide guarantees at compile-time).
public interface AsStringReprInterface {

    // Returns the `String` that represents the self value.
    public String asStringRepr();
}
