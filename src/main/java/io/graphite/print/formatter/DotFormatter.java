package main.java.io.graphite.print.formatter;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.model.Edge;
import main.java.io.graphite.print.GraphFormatter;
import main.java.io.graphite.print.GraphPrinter;
import main.java.io.graphite.result.Colors;

/**
 * Formats a graph using the Graphviz DOT language.
 *
 * <p>The generated output can be rendered with Graphviz to produce
 * diagrams of graph structure. Both directed and undirected graphs are
 * supported.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphPrinter
 * @since 2.0
 */
public final class DotFormatter
        implements GraphFormatter, Colors {

    @Override
    public String format(IGraph graph) {

        StringBuilder out = new StringBuilder();

        boolean directed = graph.isDirected();

        out.append(BOLD)
                .append(CYAN)
                .append(directed
                        ? "digraph G {"
                        : "graph G {")
                .append(RESET)
                .append("\n\n");

        String connector = directed ? " -> " : " -- ";

        for (Edge edge : graph.edges()) {

            out.append("    ")
                    .append(YELLOW)
                    .append(edge.source())
                    .append(RESET)
                    .append(connector)
                    .append(GREEN)
                    .append(edge.destination())
                    .append(RESET);

            if (graph.isWeighted()) {
                out.append(" ")
                        .append(MAGENTA)
                        .append("[label=\"")
                        .append(edge.weight())
                        .append("\"]")
                        .append(RESET);
            }

            out.append(";")
                    .append("\n");
        }

        out.append("\n")
                .append(BOLD)
                .append(CYAN)
                .append("}")
                .append(RESET);

        return out.toString();
    }
}
