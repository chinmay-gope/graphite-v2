package main.java.io.graphite.examples;

import main.java.io.graphite.exception.GraphException;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.Colors;

public final class ExamplePrinter implements Colors {

    private static final String TITLE_LINE =
            "════════════════════════════════════════════════════════════════════════════════";
    private static final String SECTION_LINE =
            "────────────────────────────────────────────────────────────────────────────────";

    private ExamplePrinter() {
    }

    /**
     * Executes a demo section with timing and exception handling.
     */
    public static void execute(String title, Runnable runnable) {
        feature(title);

        long start = System.nanoTime();

        try {
            runnable.run();

            long end = System.nanoTime();

            success();
            time(end - start);
        } catch (GraphException e) {
            failure(e);
        }

        blank();
    }

    public static void title(String title) {
        blank();

        System.out.println(TITLE_LINE);
        System.out.println(BOLD + CYAN + title + RESET);
        System.out.println(TITLE_LINE);
    }

    public static void feature(String feature) {

        blank();

        System.out.println(BLUE + "▶ " + feature + RESET);
        System.out.println(SECTION_LINE);
    }


    public static void graph(IGraph graph) {

        heading("Graph");

        field("Type",
                graph.isDirected()
                        ? "Directed"
                        : "Undirected");

        field("Vertices",
                graph.getVertices());

        field("Edges",
                graph.getEdges().size());

        field("Weighted",
                yesNo(graph.isWeighted()));

        field("Implementation",
                graph.getClass().getSimpleName());

        blank();
    }


    public static void api(String code) {

        heading("API");

        System.out.println(CYAN + code + RESET);

        blank();
    }

    public static void note(String note) {

        heading("Note");

        System.out.println(YELLOW + note + RESET);

        blank();
    }

    public static void result(Object result) {

        System.out.println(result);
    }

    // ==========================================================
    // Status
    // ==========================================================

    public static void success() {
        System.out.println(
                GREEN + "✓ Completed" + RESET
        );
    }

    public static void failure(Exception e) {
        System.out.println(
                RED + "✗ " + e.getMessage() + RESET
        );
    }

    // ==========================================================
    // Time
    // ==========================================================

    public static void time(long nanos) {
        System.out.printf(
                "%sExecution Time%s : %.3f ms%n",
                WHITE,
                RESET,
                nanos / 1_000_000.0
        );
    }

    // ==========================================================
    // Helpers
    // ==========================================================

    private static void heading(String title) {

        System.out.println(BOLD + title + RESET);
        System.out.println(SECTION_LINE);
    }

    private static void field(String name, Object value) {

        System.out.printf(
                "%-16s : %s%n",
                name,
                value
        );
    }

    private static String yesNo(boolean value) {

        return value ? "Yes" : "No";
    }

    public static void blank() {

        System.out.println();
    }
}
