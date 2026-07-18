package io.graphite.generator.pattern;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.GraphConfiguration;
import io.graphite.builder.Graphs;
import io.graphite.generator.internal.EdgeTracker;
import io.graphite.generator.internal.SpanningTreeGenerator;
import io.graphite.graph.IGraph;

public final class TreeGenerator {

    private TreeGenerator() {
    }

    public static IGraph generate(int vertices) {

        return generate(vertices, false);
    }

    public static IGraph generate(
            int vertices,
            boolean weighted) {

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
