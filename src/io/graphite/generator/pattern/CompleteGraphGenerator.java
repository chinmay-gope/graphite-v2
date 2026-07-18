package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class CompleteGraphGenerator {
    private CompleteGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        var builder = Graphs
                .undirected()
                .vertices(vertices);

        for (int i = 0; i < vertices; i++)
            for (int j = i + 1; j < vertices; j++)
                builder.addEdge(i, j);

        return builder.build();
    }
}
