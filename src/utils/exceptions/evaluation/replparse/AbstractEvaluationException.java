package fundb.utils.exceptions.evaluation.replparse;

import fundb.utils.reportable.MayReportInterface;
import fundb.utils.reportable.ReportKind;
import fundb.utils.strings.AsStringReprInterface;
import java.util.Optional;

// Generic evaluation error (refering only to `repl.evaluate` action) when passed input can't be
// evaluated / converted to tokens (or sql query is empty).
public abstract class AbstractEvaluationException extends Exception implements MayReportInterface {

}
