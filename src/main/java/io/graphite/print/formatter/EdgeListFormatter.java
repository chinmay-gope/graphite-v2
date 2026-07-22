package main.java.io.graphite.print.formatter;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.model.Edge;
import main.java.io.graphite.print.GraphFormatter;
import main.java.io.graphite.print.GraphPrinter;
import main.java.io.graphite.result.Colors;

/**
 * Formats a graph as an edge list.
 *
 * <p>Each edge is represented as a single entry containing its source,
 * destination, and optional weight. This format is useful for exporting,
 * debugging, and comparing graph structures.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphPrinter
 * @see GraphFormatter
 * @since 2.0
 */
public final class EdgeListFormatter implements GraphFormatter, Colors {

    @Override
    public String format(IGraph graph) {
        StringBuilder out = new StringBuilder();

        for (int vertex = 0; vertex < graph.vertexCount(); vertex++) {
            for (Edge edge : graph.getNeighbors(vertex)) {

                if (graph.isUndirected() && edge.source() > edge.destination()) {
                    continue;
                }

                // Source vertex in bold cyan
                out.append(BOLD).append(CYAN).append(edge.source()).append(RESET);

                // Edge line in magenta
                out.append(" ").append(MAGENTA).append("──").append(RESET);

                // Weight in yellow if weighted
                if (graph.isWeighted()) {
                    out.append(YELLOW).append("(")
                            .append(edge.weight())
                            .append(")").append(RESET);
                }

                // Edge line continuation
                out.append(MAGENTA).append("── ").append(RESET);

                // Destination vertex in green
                out.append(GREEN).append(edge.destination()).append(RESET);

                out.append('\n');
            }
        }

        return out.toString();
    }
}
