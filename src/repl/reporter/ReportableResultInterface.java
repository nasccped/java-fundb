package fundb.repl.reporter;

// Means any result type (even exceptions) that can be reported through `Reporter` object.
public interface ReportableResultInterface {

    // Returns the report kind associated with the self object.
    public ReportKind getReportKind();
}
