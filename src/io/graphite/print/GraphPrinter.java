package io.graphite.print;

import io.graphite.graph.IGraph;
import io.graphite.print.formatter.*;

/**
 * Utility class for rendering graphs in multiple textual formats.
 *
 * <p>{@code GraphPrinter} provides a unified entry point for Graphite's
 * formatting framework, allowing graphs to be displayed in compact,
 * tabular, visualization, and structured data formats.</p>
 *
 * <pre>{@code
 * GraphPrinter.compact(graph);
 * GraphPrinter.matrix(graph);
 * GraphPrinter.statistics(graph);
 * GraphPrinter.dot(graph);
 * GraphPrinter.mermaid(graph);
 * GraphPrinter.json(graph);
 * }</pre>
 *
 * <h2>Supported Formats</h2>
 *
 * <ul>
 *     <li>Compact</li>
 *     <li>Edge List</li>
 *     <li>Adjacency Matrix</li>
 *     <li>Statistics</li>
 *     <li>DOT (Graphviz)</li>
 *     <li>Mermaid</li>
 *     <li>JSON</li>
 * </ul>
 *
 * <p>All formatting implementations are stateless singleton instances,
 * allowing them to be reused without additional allocation.</p>
 *
 * @since 2.0
 */
public final class GraphPrinter {

    private static final GraphFormatter COMPACT = new CompactFormatter();
    private static final GraphFormatter TREE = new TreeFormatter();
    private static final GraphFormatter EDGE_LIST = new EdgeListFormatter();
    private static final GraphFormatter MATRIX = new MatrixFormatter();
    private static final GraphFormatter STATISTICS = new StatisticsFormatter();
    private static final GraphFormatter DOT = new DotFormatter();
    private static final GraphFormatter MERMAID = new MermaidFormatter();
    private static final GraphFormatter JSON = new JsonFormatter();

    private GraphPrinter() {
    }

    public static void compact(IGraph graph) {
        System.out.println(COMPACT.format(graph));
    }

    public static void tree(IGraph graph) {
        System.out.println(TREE.format(graph));
    }

    public static void edgeList(IGraph graph) {
        System.out.println(EDGE_LIST.format(graph));
    }

    public static void matrix(IGraph graph) {
        System.out.println(MATRIX.format(graph));
    }

    public static void statistics(IGraph graph) {
        System.out.println(STATISTICS.format(graph));
    }

    public static void dot(IGraph graph) {
        System.out.println(DOT.format(graph));
    }

    public static void mermaid(IGraph graph) {
        System.out.println(MERMAID.format(graph));
    }

    public static void json(IGraph graph) {
        System.out.println(JSON.format(graph));
    }

    // preserve compatibility
    public static void println(IGraph graph) {
        compact(graph);
    }
}
