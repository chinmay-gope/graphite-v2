package io.graphite.print.formatter;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.print.GraphFormatter;
import io.graphite.result.Colors;

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
