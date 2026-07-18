package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class StarGenerator {

    private StarGenerator() {
    }

    public static IGraph generate(int vertices) {

        var builder = Graphs
                .undirected()
                .vertices(vertices);

        for (int i = 1; i < vertices; i++)
            builder.addEdge(0, i);

        return builder.build();
    }
}
