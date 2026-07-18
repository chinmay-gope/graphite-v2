package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class StarGraphGenerator {

    private StarGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        if (vertices < 2) {
            throw new IllegalArgumentException(
                    "Star graph requires at least 2 vertices.");
        }

        var builder = Graphs
                .undirected()
                .vertices(vertices);

        for (int i = 1; i < vertices; i++)
            builder.addEdge(0, i);

        return builder.build();
    }
}
