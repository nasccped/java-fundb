package fundb.utils.reportable;

import fundb.utils.strings.AsStringReprInterface;
import java.lang.Iterable;

// Means any object that carries multiline info.
public interface MultilineContentInterface {

    // Returns the content as iterable. Note that all items are expected to implement
    // `AsStringReprInterface` since it need to be print by repl `Reporter`.
    abstract public Iterable<? extends AsStringReprInterface> getContentLines();
}
