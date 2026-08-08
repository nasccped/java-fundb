package fundb.database;

import fundb.tokens.TokenSequence;
import fundb.repl.Repl;
import fundb.utils.exceptions.execution.AbstractDatabaseExecutionException;
import fundb.utils.result.AbstractDatabaseExecutionResult;

// Manage all databases, executable queries and so on...
public class DatabaseManager {
    
    // Repl reference (if exit command is called).
    private Repl replEnv;

    public DatabaseManager(Repl repl) {
        this.replEnv = repl;
    }

    // Takes a `TokenSequence` and converts it to an `AbstractExecutionResult`. The execution can
    // fail and raise any `AbstractDatabaseExecutionException` extender.
    public AbstractDatabaseExecutionResult execute(TokenSequence ts)
    throws AbstractDatabaseExecutionException {
        throw new UnsupportedOperationException(String.format(
            "`%s::%s` operation wasn't implemented yet",
            getClass().getSimpleName(),
            "execute"
        ));
    }
}
