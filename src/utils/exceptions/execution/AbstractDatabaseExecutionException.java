package fundb.utils.exceptions.execution;

// Refers to any exception that can occurs at `DatabaseManager.execute` function call. Note that
// this exception is just an extension of `AbstractExecutionException` (which can be thrown by the
// `repl.execute` function call). It doesn't implements the `MayReportInterface`, which is required
// by the parent class. That's just a way to avoid mixed non-related exceptions mess at java files.
public abstract class AbstractDatabaseExecutionException extends AbstractExecutionException {

}
