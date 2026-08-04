package fundb.database;

import fundb.exceptions.NotImplementedYetException;
import fundb.repl.Repl;

// Manage all databases, executable queries and so on...
public class DatabaseManager {
    
    // Running environment (when repl.terminate is required).
    private Repl env;

    public DatabaseManager(Repl env) {
        this.env = env;
    }

    // Executes the s `String` command and returns if the execution was succeeded.
    public boolean execute(String s) {
        // if exit called
        if (s.toLowerCase().equalsIgnoreCase("exit;")) {
            env.terminate();
            return true;

          // if help called
        } else if (s.toLowerCase().equalsIgnoreCase("help;"))
            throw new NotImplementedYetException("DatabaseManager help cmd execution");

        // else.
        return false;
    }
}
