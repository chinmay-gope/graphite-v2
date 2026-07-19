package io.graphite.print;

import io.graphite.graph.IGraph;
import io.graphite.print.formatter.CompactFormatter;
import io.graphite.print.formatter.EdgeListFormatter;
import io.graphite.print.formatter.TreeFormatter;

// Facade
public final class GraphPrinter {

    private GraphPrinter() {
    }

    public static void compact(IGraph graph) {
        System.out.print(new CompactFormatter().format(graph));
        newLine();
    }

    public static void tree(IGraph graph) {
        System.out.print(new TreeFormatter().format(graph));
        newLine();
    }

    public static void edgeList(IGraph graph) {
        System.out.print(new EdgeListFormatter().format(graph));
        newLine();
    }

    // preserve compatibility
    public static void print(IGraph graph) {
        compact(graph);
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }
}
