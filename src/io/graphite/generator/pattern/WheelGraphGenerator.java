package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class WheelGraphGenerator {

    private WheelGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        if (vertices < 4)
            throw new IllegalArgumentException(
                    "Wheel graph requires at least 4 vertices.");

        var builder =
                Graphs.undirected()
                        .vertices(vertices);

        for (int i = 1; i < vertices; i++) {

            builder.addEdge(
                    i,
                    i == vertices - 1
                            ? 1 : i + 1);

            builder.addEdge(0, i);
        }

        return builder.build();
    }
}
