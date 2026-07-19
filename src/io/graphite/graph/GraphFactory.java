package io.graphite.graph;

import io.graphite.builder.GraphConfiguration;
import io.graphite.builder.Graphs;
import io.graphite.builder.UndirectedGraphBuilder;
import io.graphite.exception.graph.InvalidGraphConfigurationException;
import io.graphite.generator.pattern.BipartiteGraphGenerator;

public final class GraphFactory {

    public static final double DENSITY = 0.75;

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

    public static IGraph traversalGraph(int vertices) {

        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected()
                .generate();
    }

    public static IGraph mstGraph(int vertices) {
        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges(vertices * 3)
                .weighted()
                .connected()
                .generate();
    }

    public static IGraph denseGraph(int vertices) {

        return denseGraph(vertices, DENSITY);
    }

    public static IGraph directedDenseGraph(int vertices) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * 0.75);

        return Graphs.random()
                .directed()
                .vertices(vertices)
                .edges(edges)
                .connected()
                .generate();
    }

    public static IGraph denseGraph(int vertices, double density) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * density);

        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected()
                .generate();
    }

    public static IGraph denseWeightedGraph(int vertices) {

        int maxEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maxEdges * DENSITY);

        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected()
                .weightRange(1, 50)
                .generate();
    }

    public static IGraph weightedGraph(int vertices) {

        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected()
                .weightRange(1, 50)
                .generate();
    }

    public static IGraph directedGraph(int vertices) {

        return Graphs.random()
                .directed()
                .vertices(vertices)
                .edges(vertices * 2)
                .generate();
    }

    public static IGraph sparseGraph(int vertices) {

        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected()
                .generate();
    }

    public static IGraph directedSparseGraph(int vertices) {

        return Graphs.random()
                .directed()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected()
                .generate();
    }

    public static IGraph treeGraph(int vertices) {

        return Graphs.random()
                .undirected()
                .vertices(vertices)
                .edges(vertices - 1)
                .connected()
                .generate();
    }

    public static IGraph dag(int vertices) {

        return Graphs.dag(vertices);
    }

    public static IGraph bipartiteGraph(int vertices) {

        int left = vertices / 2;
        int right = vertices - left;

        return BipartiteGraphGenerator.generate(
                left,
                right,
                left + right
        );
    }

    public static IGraph bipartiteGraph(int left, int right) {

        return BipartiteGraphGenerator.generate(
                left,
                right,
                left + right
        );
    }

    public static IGraph bipartiteGraph(int left, int right, int edges) {

        return BipartiteGraphGenerator.generate(
                left,
                right,
                edges
        );
    }

    public static IGraph eulerCircuitGraph(int vertices) {

        if (vertices < 3) {
            throw new InvalidGraphConfigurationException(
                    "Euler circuit requires at least 3 vertices.");
        }

        UndirectedGraphBuilder builder = Graphs.undirected();

        // Base cycle
        for (int i = 0; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        builder.addEdge(vertices - 1, 0);

        return builder.build();
    }

    public static IGraph eulerPathGraph(int vertices) {

        if (vertices < 2) {
            throw new InvalidGraphConfigurationException(
                    "Euler path requires at least 2 vertices.");
        }

        UndirectedGraphBuilder builder = Graphs.undirected();

        for (int i = 0; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        return builder.build();
    }

    public static IGraph invalidEulerGraph(int vertices) {

        if (vertices < 5) {
            throw new InvalidGraphConfigurationException(
                    "Invalid Euler graph requires at least 5 vertices.");
        }

        UndirectedGraphBuilder builder = Graphs.undirected();

        for (int i = 1; i < vertices; i++) {
            builder.addEdge(0, i);
        }

        return builder.build();
    }

    public static IGraph disconnectedEulerGraph(int vertices) {

        UndirectedGraphBuilder builder = Graphs.undirected();

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
