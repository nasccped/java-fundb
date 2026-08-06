package fundb.repl;

import fundb.repl.ReportableResultInterface;

// Means any kind of exception that occurs at `repl.execute` function. That's just an abstract
// class and should be implemented by the `databasemanager` actual exceptions.
public abstract class AbstractExecutionException
extends Exception
implements ReportableResultInterface {

    // Since all exceptions are fails, we can easily:
    public ReportableResultInterface.ReportKind getReportKind() {
        return ReportableResultInterface.ReportKind.FAIL;
    }
}
