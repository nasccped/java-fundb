package fundb.repl.reporter;

import fundb.repl.printer.Printer;

public class Reporter {

    // Auxiliar printer reference.
    private Printer printer;

    public Reporter(Printer printer) {
        this.printer = printer;
    }

    // Does the actual reporting.
    public void reportResult(ReportableResultInterface result) {

        // ignore if quiet report.
        if (!shouldBeReported(result))
            return;

        // TODO: implement error reporting logic.
        throw new UnsupportedOperationException("TODO: implement reporting logic");
    }

    // Returns if the given result should be reported to sysout.
    private boolean shouldBeReported(ReportableResultInterface result) {
        return result.getReportKind() != ReportKind.QUIET;
    }
}
