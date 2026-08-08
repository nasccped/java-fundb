package fundb.utils.reportable;

import java.util.Optional;

// Interface that ensures: the current object may (or not) returns a `Report` reference.
public interface MayReportInterface {

    // Optionally returns a `Report` reference (empty `Optional` means that the current item
    // doesn't provide a report - just skip reporting).
    public Optional<Report> mayReport();
}
