package fundb.repl.reporter;

import fundb.repl.printer.Printer;
import fundb.utils.reportable.Report;
import fundb.utils.reportable.ReportKind;
import fundb.utils.reportable.MayReportInterface;
import fundb.utils.reportable.MultilineContentInterface;
import fundb.utils.strings.AsStringReprInterface;
import java.util.Optional;

public class Reporter {

    // Auxiliar printer reference.
    private Printer printer;

    public Reporter(Printer printer) {
        this.printer = printer;
    }

    // Does the actual reporting.
    public void reportResult(MayReportInterface result) {
        Report report;
        ReportKind kind;
        int initialGap;

        // null data means no data
        if ((report = result.mayReport().orElse(null)) == null)
            return;

        initialGap = printer.getLeftGap();

        // if report kind expected to be displayed (not anonymous).
        if ((kind = report.getReportKind()).isKindRepresentable()) {

            printer.print(kind.asStringRepr());
            printer.print(' ');

            // update new gap for content-aligned printing.
            printer.setLeftGap(initialGap + kind.getStringLength() + 1);
        }

        // Print title for the current report.
        printer.println(report.getTitleString());

        // Print detail if necessary.
        report.optionalDetail().ifPresent(detail -> {
            printer.println(detail.getDetailString());
        });

        report.optionalMultilineContent().ifPresent(mc -> {
            // gap from previous detail.
            printer.println();

            for (AsStringReprInterface row : mc.getContentLines())
                printer.println(row.asStringRepr());
        });

        // 1 row gap for next reading + reset left gap.
        printer.println();
        printer.setLeftGap(initialGap);
    }
}
