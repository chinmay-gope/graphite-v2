package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class GridGraphGenerator {

    private GridGraphGenerator() {

    }

    public static IGraph generate(int rows, int cols) {

        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException(
                    "Grid dimensions must be positive.");
        }

        int vertices = rows * cols;

        var builder =
                Graphs.undirected()
                        .vertices(vertices);

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                int current = r * cols + c;

                if (c + 1 < cols)
                    builder.addEdge(current, current + 1);

                if (r + 1 < rows)
                    builder.addEdge(current, current + cols);
            }
        }

        return builder.build();
    }
}
