package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.exception.graph.InvalidGraphConfigurationException;
import io.graphite.graph.IGraph;

public final class CycleGraphGenerator {
    private CycleGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        if (vertices < 3) {
            throw new InvalidGraphConfigurationException(
                    "Cycle graph requires at least 3 vertices.");
        }

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
