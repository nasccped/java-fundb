package fundb.utils.exceptions.evaluation.replparse;

import fundb.utils.exceptions.evaluation.replparse.AbstractEvaluationException;
import fundb.utils.reportable.Report;
import java.util.Optional;

// This exception means that the SQL query is just an empty (or whitespace) `String`. Not
// necessarily an error but must be throw since `TokenSequence` constructor expects a non-empty
// collection as parameter.
public class EmptyQueryException extends AbstractEvaluationException {

    // No error, just empty query.
    public EmptyQueryException() {
        super();
    }

    // Empty shouldn't be reported (since it isn't an error).
    public Optional<Report> mayReport() {
        return Optional.empty();
    }
}
