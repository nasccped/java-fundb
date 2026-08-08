package fundb.utils.reportable;

import fundb.utils.strings.AsStringReprInterface;
import java.util.Optional;

// Refers to a `Report` instance, a structured data type that allows info displaying.
public final class Report {

    // Kind of report associated with to this data.
    private final ReportKind reportKind;

    // Means the title of action (such as 'table created' and so on).
    private TitleInterface title;

    // Means a short detail that comes with the data (such as `failed at %s parsing`,
    // `table already exists`, ...). That's optional since not all types guarantees a detail info.
    private Optional<DetailInterface> detail;

    // Multiline data. Consider reading `MultilineContentInterface` doc to check implementing
    // requirements.
    private Optional<MultilineContentInterface> multilineContent;

    // NOTE:
    //  1. All reports should guarantee at least a kind (even when anonymous) and a title.
    //  2. `detail` and `multilineContent` are empty by default. Use setters if necessary.
    //  3. There's no 'unset' methods for detail and multilines. Use instead `withDetail(null)` and
    //     so on.
    //  4. Once created, `kind` can't be changed.
    public Report(ReportKind kind, TitleInterface title) {
        this.reportKind = kind;
        this.title = title;
        this.detail = Optional.empty();
        this.multilineContent = Optional.empty();
    }

    // Sets a new custom title + returns the self object reference. Note that the set operation can
    // 'avoid' set new value if t refers to `null` (since report requires title).
    public Report withTitle(TitleInterface t) {
        if (t != null)
            title = t;
        return this;
    }

    // Sets a new `detail` value + returns the self reference. `null` reference reset detail to
    // empty optional.
    public Report withDetail(DetailInterface d) {
        detail = Optional.ofNullable(d);
        return this;
    }

    // Sets a new `multilineContent` value + returns the self reference. `null` reference reset
    // multilineContent to empty optional.
    public Report withMultilineContent(MultilineContentInterface mc) {
        multilineContent = Optional.ofNullable(mc);
        return this;
    }

    // Returns the optional detail reference.
    public Optional<DetailInterface> optionalDetail() {
        return detail;
    }

    // Returns the optional multiline content reference.
    public Optional<MultilineContentInterface> optionalMultilineContent() {
        return multilineContent;
    }

    // Returns the report kind associated with the self object.
    public ReportKind getReportKind() {
        return reportKind;
    }

    // Returns the title of current report (already as String).
    public String getTitleString() {
        return title.getTitleString();
    }
}
