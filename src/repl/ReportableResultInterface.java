package fundb.repl;

// Means any result type (even exceptions) that can be reported through `Repl` printer.
public interface ReportableResultInterface {

    // Kind of report.
    public enum ReportKind {
        // When everything was done well.
        DONE,

        // When some fail occurs.
        FAIL,

        // When stuff is done but warnings are generated.
        WARN,

        // Anonymous report (just raw text).
        ANON;
    }

    // Returns the report kind associated with the self object.
    public ReportKind getReportKind();
}
