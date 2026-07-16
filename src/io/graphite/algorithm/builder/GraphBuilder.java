package io.graphite.algorithm.builder;

import io.graphite.algorithm.graph.GraphFactory;
import io.graphite.algorithm.graph.GraphType;
import io.graphite.algorithm.graph.Graph;

public final class GraphBuilder {
    private final Graph graph;

    private GraphBuilder(GraphType type, int vertices) {
        this.graph = GraphFactory.create(type, vertices);
    }

    public static GraphBuilder directed(int vertices) {
        return new GraphBuilder(GraphType.DIRECTED, vertices);
    }

    public static GraphBuilder undirected(int vertices) {
        return new GraphBuilder(GraphType.UNDIRECTED, vertices);
    }

    public GraphBuilder addEdge(int from, int to) {
        graph.addEdge(from, to);
        return this;
    }

    public GraphBuilder addEdge(int from, int to, int weight) {
        graph.addEdge(from, to, weight);
        return this;
    }

    public Graph build() {
        return graph;
    }
}
