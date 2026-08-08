package fundb.utils.exceptions.execution;

import fundb.utils.reportable.MayReportInterface;

// Means any kind of exception that occurs at `repl.execute` function. That's just an abstract
// class and should be extended by the `databasemanager` actual exceptions.
public abstract class AbstractExecutionException extends Exception implements MayReportInterface {

}
