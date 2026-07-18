package io.graphite.examples.util;

import io.graphite.graph.IGraph;
import io.graphite.result.Result;

public final class DemoPrinter implements Result {

    private static final String LINE =
            "════════════════════════════════════════════════════════════════════════════════";

    private DemoPrinter() {
        throw new AssertionError("Utility class");
    }

    public static void printHeader(String title, IGraph graph) {
        blankLine();
        printLine();

        System.out.printf("%sDemo:%s %s%n",
                WHITE, RESET,
                CYAN + title + RESET);

        printGraphSummary(graph);

        printLine();
    }

    public static void printGraphSummary(IGraph graph) {

        System.out.printf("%sGraph Type :%s %s%n",
                WHITE,
                RESET,
                YELLOW + graph.getGraphType() + RESET);

        System.out.printf("%sVertices   :%s %d%n",
                WHITE,
                RESET,
                graph.getVertices());
    }

    public static void printSection(String title) {

        blankLine();

        System.out.printf(
                "%s▶ %s%s%n",
                BLUE,
                title,
                RESET
        );

        printLine();
    }

    public static void printSubSection(String title) {

        System.out.printf(
                "%s➜ %s%s%n",
                CYAN,
                title,
                RESET
        );
    }

    public static void printSuccess() {

        System.out.println(
                GREEN + "✓ Success" + RESET
        );
    }

    public static void printFailure(Exception e) {

        System.err.println(
                RED + "✗ " + e.getMessage() + RESET
        );
    }

    public static void printExecutionTime(long nanos) {

        System.out.printf(
                "%sExecution Time:%s %.3f ms%n",
                WHITE,
                RESET,
                nanos / 1_000_000.0
        );
    }

    public static void printLine() {
        System.out.println(LINE);
    }

    public static void blankLine() {
        System.out.println();
    }
}
