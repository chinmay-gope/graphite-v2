package io.graphite.generator.pattern;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.GraphConfiguration;
import io.graphite.builder.Graphs;
import io.graphite.exception.graph.InvalidGraphConfigurationException;
import io.graphite.generator.internal.EdgeTracker;
import io.graphite.generator.internal.SpanningTreeGenerator;
import io.graphite.graph.IGraph;
import io.graphite.graph.PatternGraphBuilder;

/**
 * Generates tree graphs.
 *
 * <p>A tree is a connected, acyclic, undirected graph containing exactly
 * {@code V - 1} edges. Every pair of vertices is connected by exactly one
 * simple path.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see PatternGraphBuilder
 * @since 2.0
 */
public final class TreeGraphGenerator {

    private TreeGraphGenerator() {
    }

    public static IGraph generate(int vertices) {

        return generate(vertices, false);
    }

    public static IGraph generate(
            int vertices,
            boolean weighted) {

        if (vertices <= 0) {
            throw new InvalidGraphConfigurationException(
                    "Tree requires at least one vertex.");
        }

        GraphConfiguration configuration =
                new GraphConfiguration();

        configuration.setVertices(vertices);
        configuration.setWeighted(weighted);
        configuration.setConnected(true);

        AbstractGraphBuilder<?, ?> builder = Graphs
                .undirected()
                .vertices(vertices)
                .weighted(weighted);

        EdgeTracker tracker =
                new EdgeTracker(configuration);

        SpanningTreeGenerator.generate(
                builder,
                configuration,
                tracker);

        return builder.build();
    }
}
