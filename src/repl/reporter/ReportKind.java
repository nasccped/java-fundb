package fundb.repl.reporter;

// Kind of report.
public enum ReportKind {

    // When everything was done well.
    DONE,

    // When some fail occurs.
    FAIL,

    // When stuff is done but warnings are generated.
    WARN,

    // Anonymous report (just raw text).
    ANON,

    // No report.
    QUIET
}
