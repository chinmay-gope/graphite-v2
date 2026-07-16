package io.graphite.algorithm.graph;

import io.graphite.algorithm.generator.RandomGraphGenerator;
import io.graphite.algorithm.builder.GraphBuilder;

public final class GraphFactory {

    public static final double DENSITY = 0.75;

    private GraphFactory() {
    }

    public static Graph create(GraphType type, int vertices) {
        return switch (type) {

            case DIRECTED -> new DirectedGraph(vertices);

            case UNDIRECTED -> new UnDirectedGraph(vertices);
        };
    }

    public static Graph traversalGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected(true)
                .build();
    }

    public static Graph mstGraph(int vertices) {
        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices * 3)
                .weighted(true)
                .connected(true)
                .build();
    }

    public static Graph denseGraph(int vertices) {

        return denseGraph(vertices, DENSITY);
    }

    public static Graph directedDenseGraph(int vertices) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * 0.75);

        return RandomGraphGenerator
                .directed()
                .vertices(vertices)
                .edges(edges)
                .connected(true)
                .build();
    }

    public static Graph denseGraph(int vertices, double density) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * density);

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected(true)
                .build();
    }

    public static Graph denseWeightedGraph(int vertices) {

        int maxEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maxEdges * DENSITY);

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected(true)
                .weighted(true)
                .weightRange(1, 50)
                .build();
    }

    public static Graph weightedGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected(true)
                .weighted(true)
                .weightRange(1, 50)
                .build();
    }

    public static Graph directedGraph(int vertices) {

        return RandomGraphGenerator
                .directed()
                .vertices(vertices)
                .edges(vertices * 2)
                .build();
    }

    public static Graph sparseGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected(true)
                .build();
    }

    public static Graph directedSparseGraph(int vertices) {

        return RandomGraphGenerator
                .directed()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected(true)
                .build();
    }

    public static Graph treeGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices - 1)
                .connected(true)
                .build();
    }

    public static Graph dag(int vertices) {

        return RandomGraphGenerator
                .dag(vertices);
    }

    public static Graph bipartiteGraph(int vertices) {

        return RandomGraphGenerator
                .bipartiteGraph(vertices);
    }

    public static Graph eulerCircuitGraph(int vertices) {

        if (vertices < 3) {
            throw new IllegalArgumentException(
                    "Euler circuit requires at least 3 vertices.");
        }

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        // Base cycle
        for (int i = 0; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        builder.addEdge(vertices - 1, 0);

        return builder.build();
    }

    public static Graph eulerPathGraph(int vertices) {

        if (vertices < 2) {
            throw new IllegalArgumentException(
                    "Euler path requires at least 2 vertices.");
        }

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        for (int i = 0; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        return builder.build();
    }

    public static Graph invalidEulerGraph(int vertices) {

        if (vertices < 5) {
            throw new IllegalArgumentException(
                    "Invalid Euler graph requires at least 5 vertices.");
        }

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        for (int i = 1; i < vertices; i++) {
            builder.addEdge(0, i);
        }

        return builder.build();
    }

    public static Graph disconnectedEulerGraph(int vertices) {

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        int mid = vertices / 2;

        for (int i = 0; i < mid - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        for (int i = mid; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        return builder.build();
    }

}
