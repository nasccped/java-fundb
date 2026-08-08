package fundb.utils.reportable;

import fundb.utils.strings.AsStringReprInterface;

// Means an abstract `Detail`, data type that carries more info of the result abstraction.
//
// This class comes empty by default just to ensure (at compile time) that ALL provided types (as
// detail extender) provides the required api.
public interface DetailInterface {

    // Returns the detail as `String` message.
    abstract public String getDetailString();
}
