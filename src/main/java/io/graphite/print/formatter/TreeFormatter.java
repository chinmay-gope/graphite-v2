package main.java.io.graphite.print.formatter;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.model.Edge;
import main.java.io.graphite.print.GraphFormatter;
import main.java.io.graphite.result.Colors;

public final class TreeFormatter implements GraphFormatter, Colors {

    @Override
    public String format(IGraph graph) {
        StringBuilder out = new StringBuilder();

        for (int vertex = 0; vertex < graph.vertexCount(); vertex++) {
            // Print the root vertex in bold cyan
            out.append(BOLD).append(CYAN).append(vertex).append(RESET).append('\n');

            var neighbours = graph.getNeighbors(vertex);

            for (int i = 0; i < neighbours.size(); i++) {
                Edge edge = neighbours.get(i);
                boolean last = i == neighbours.size() - 1;

                // Branch symbols in magenta
                out.append(MAGENTA).append(last ? "└── " : "├── ").append(RESET);

                // Destination in green
                out.append(GREEN).append(edge.destination()).append(RESET);

                if (graph.isWeighted()) {
                    // Weight in yellow
                    out.append(" ").append(YELLOW)
                            .append("(").append(edge.weight()).append(")")
                            .append(RESET);
                }

                out.append('\n');
            }

            out.append('\n');
        }

        return out.toString();
    }
}
