package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.exception.graph.InvalidGraphConfigurationException;
import io.graphite.graph.IGraph;
import io.graphite.graph.PatternGraphBuilder;

/**
 * Generates wheel graphs.
 *
 * <p>A wheel graph consists of a cycle together with a central hub vertex
 * connected to every vertex on the cycle.</p>
 *
 * @author Chinmay
 * @since 2.0
 * @version 2.0
 *
 * @see PatternGraphBuilder
 */
public final class WheelGraphGenerator {

    private WheelGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        if (vertices < 4)
            throw new InvalidGraphConfigurationException(
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
