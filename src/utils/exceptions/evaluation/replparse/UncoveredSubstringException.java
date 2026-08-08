package fundb.utils.exceptions.evaluation.replparse;

import fundb.utils.exceptions.evaluation.replparse.AbstractEvaluationException;
import fundb.utils.reportable.DetailInterface;
import fundb.utils.reportable.Report;
import fundb.utils.reportable.ReportKind;
import fundb.utils.reportable.TitleInterface;
import fundb.utils.strings.AsStringReprInterface;
import java.util.Optional;

// When token parsing doesn't cover the entire string (means that some string slice isn't
// recognized as valid token, which isn't expected).
public class UncoveredSubstringException
extends AbstractEvaluationException
implements TitleInterface, DetailInterface {

    // Carries the title of the current substring.
    private final String substring;

    // Substring index range.
    private final int beginIndex, endIndex;

    // How many uncovered.
    private int uncoveredSubstringsCount;

    public UncoveredSubstringException(String substring, int begin, int end) {
        super();
        this.substring = substring;
        this.beginIndex = begin;
        this.endIndex = end;
        // init as 1 (for current one).
        this.uncoveredSubstringsCount = 1;
    }

    // Increments the counting of uncovered substrings.
    public void increment() {
        uncoveredSubstringsCount++;
    }

    // This will report not covered token error.
    public Optional<Report> mayReport() {
        // use self title
        Report rep = new Report(ReportKind.FAIL, this);

        // use self detail only if more than 1 uncovered substring.
        return Optional.of(rep.withDetail(uncoveredSubstringsCount > 1 ? this : null));
    }

    // Turn this object into a valid detail.
    public String getDetailString() {
        int howMany = uncoveredSubstringsCount - 1;
        boolean plural = howMany > 1;

        return String.format("Other %d substring%s not covered!", howMany, plural ? "s" : "");
    }

    // Turn it into an acceptable title.
    public String getTitleString() {
        return String.format(
            "Uncovered substring on query: %s [%d..%d] (not recognized in regex pattern)",
            substring,
            beginIndex,
            endIndex
        );
    }
}
