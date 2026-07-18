package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class CycleGenerator {
    private CycleGenerator() {
    }

    public static IGraph generate(int vertices) {

        var builder = Graphs
                .undirected()
                .vertices(vertices);

        for (int i = 0; i < vertices; i++) {

            builder.addEdge(
                    i,
                    (i + 1) % vertices);
        }

        return builder.build();
    }
}
