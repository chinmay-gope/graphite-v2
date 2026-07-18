package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class GridGenerator {

    private GridGenerator() {

    }

    private int rows;
    private int cols;

    public GridGenerator rows(int rows) {
        this.rows = rows;
        return this;
    }

    public GridGenerator columns(int cols) {
        this.cols = cols;
        return this;
    }

    public IGraph generate() {

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
