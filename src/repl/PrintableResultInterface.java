package fundb.repl;

import java.util.List;
import java.util.Optional;

// An interface for printable items.
//
// Since the `Printer` can only print `Object`s that implements this interface, all resultant
// `Object`s and `Exception` should implement it to be catch by the repl printer.
public interface PrintableResultInterface {

    // Inner status for the current operation.
    enum Status {
        // `OK` means that the action was done well.
        OK,

        // `ERR` means that something went wrong.
        ERR,

        // `WARN` means that the operation was partially done.
        WARN,

        // `ANON` (anonymous) means that the operation was done but it isn't important.
        ANON;

        @Override
        public String toString() {
            switch (this) {
                case ANON:
                    return "report";

                default:
                    return this.name().toLowerCase();
            }
        }
    }

    // Return the inner status for the current operation.
    Status getStatus();

    // Returns the action kind performed by the current operation.
    String getActionKind();

    // Returns the description message for the current operation.
    String getDescription();

    // Optionally the operation data in rows (for multiline printing). This function returns
    // `Optional.empty()` by default.
    default Optional<List<String>> getStringRows() {
        return Optional.empty();
    }
}
