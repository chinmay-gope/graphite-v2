package io.graphite.graph;

import io.graphite.builder.GraphConfiguration;

public final class GraphFactory {

    public final GraphFactory INSTANCE = new GraphFactory();

    private GraphFactory() {
    }

    public static DirectedGraph directed(
            GraphConfiguration configuration) {

        return new DirectedGraph(configuration);
    }

    public static UndirectedGraph undirected(
            GraphConfiguration configuration) {

        return new UndirectedGraph(configuration);
    }

    public static IGraph create(GraphConfiguration configuration) {
        return configuration.isDirected()
                ? directed(configuration)
                : undirected(configuration);
    }
}
