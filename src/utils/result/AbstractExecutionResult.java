package fundb.utils.result;

import fundb.utils.reportable.MayReportInterface;

// Abstract class for any kind of result (that's actually reportable through repl reporter).
//
// Note that this class is empty. It should instead be extended and implement `MayReportInterface`
// on final extender. That one is used just to ensure repl execution main interface.
public abstract class AbstractExecutionResult implements MayReportInterface {

}
