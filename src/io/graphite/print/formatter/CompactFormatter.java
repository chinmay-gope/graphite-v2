package io.graphite.print.formatter;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.print.GraphFormatter;
import io.graphite.result.Colors;

public final class CompactFormatter implements GraphFormatter, Colors {

    @Override
    public String format(IGraph graph) {
        StringBuilder out = new StringBuilder();

        for (int vertex = 0; vertex < graph.vertexCount(); vertex++) {
            // Vertex styled in bold cyan
            out.append(BOLD).append(CYAN).append(vertex).append(RESET)
                    .append(" ").append(MAGENTA).append("-> ").append(RESET);

            var neighbours = graph.getNeighbors(vertex);

            for (int i = 0; i < neighbours.size(); i++) {
                Edge edge = neighbours.get(i);

                // Destination styled in green
                out.append(GREEN).append(edge.destination()).append(RESET);

                if (graph.isWeighted()) {
                    // Weight styled in yellow
                    out.append(YELLOW).append("(")
                            .append(edge.weight())
                            .append(")").append(RESET);
                }

                if (i < neighbours.size() - 1) {
                    // Separator styled in white
                    out.append(WHITE).append(", ").append(RESET);
                }
            }

            out.append('\n');
        }

        return out.toString();
    }

}
