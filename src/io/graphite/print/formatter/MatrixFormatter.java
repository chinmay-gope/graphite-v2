package io.graphite.print.formatter;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.print.GraphFormatter;

import static io.graphite.result.Colors.*;

public final class MatrixFormatter implements GraphFormatter {

    @Override
    public String format(IGraph graph) {
        StringBuilder out = new StringBuilder();
        int n = graph.vertexCount();

        // Title in bold cyan
        out.append(BOLD).append(CYAN).append("Adjacency Matrix").append(RESET).append("\n\n");

        // Header row (vertex indices)
        out.append("    ");
        for (int i = 0; i < n; i++) {
            out.append(BOLD).append(BLUE)
                    .append(String.format("%4d", i))
                    .append(RESET);
        }
        out.append('\n');

        // Matrix rows
        for (int i = 0; i < n; i++) {
            // Row label in bold magenta
            out.append(BOLD).append(MAGENTA)
                    .append(String.format("%3d ", i))
                    .append(RESET);

            for (int j = 0; j < n; j++) {
                int value = 0;

                for (Edge edge : graph.getNeighbors(i)) {
                    if (edge.destination() == j) {
                        value = graph.isWeighted() ? edge.weight() : 1;
                        break;
                    }
                }

                // Color-coded cell values
                if (value == 0) {
                    out.append(WHITE).append(String.format("%4d", value)).append(RESET);
                } else if (value == 1) {
                    out.append(GREEN).append(String.format("%4d", value)).append(RESET);
                } else {
                    out.append(YELLOW).append(String.format("%4d", value)).append(RESET);
                }
            }

            out.append('\n');
        }

        return out.toString();
    }
}
