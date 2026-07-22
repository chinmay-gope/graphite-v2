package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.exception.graph.InvalidGraphConfigurationException;
import io.graphite.graph.IGraph;
import io.graphite.graph.PatternGraphBuilder;

/**
 * Generates star graphs.
 *
 * <p>A star graph consists of one central vertex connected directly to all
 * remaining vertices, which have no connections between themselves.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see PatternGraphBuilder
 * @since 2.0
 */
public final class StarGraphGenerator {

    private StarGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        if (vertices < 2) {
            throw new InvalidGraphConfigurationException(
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
