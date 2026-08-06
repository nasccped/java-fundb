package fundb.repl.evaluator;

import fundb.repl.ReportableResultInterface;

// Generic evaluation error (when passed input can't be evaluated - converted to tokens).
public class EvaluationException extends Exception implements ReportableResultInterface {

    public ReportableResultInterface.ReportKind getReportKind() {
        return ReportableResultInterface.ReportKind.FAIL;
    }
}
