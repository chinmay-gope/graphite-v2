package io.graphite.generator.preset;

import io.graphite.builder.Graphs;
import io.graphite.generator.pattern.BipartiteGraphGenerator;
import io.graphite.graph.IGraph;

public class GraphPresetFactory {

    private static final double DENSITY = 0.75;

    public static final GraphPresetFactory INSTANCE = new GraphPresetFactory();

    private GraphPresetFactory() {

    }

    public GraphPresetFactory presets() {
        return new GraphPresetFactory();
    }

    public static IGraph traversalGraph(int vertices) {

        return Graphs.random()
                .undirected()
                .immutable()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected()
                .generate();
    }

    public static IGraph mstGraph(int vertices) {
        return Graphs.random()
                .undirected()
                .immutable()
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
                .immutable()
                .vertices(vertices)
                .edges(edges)
                .connected()
                .generate();
    }

    public static IGraph denseGraph(int vertices, double density) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * density);

        return Graphs.random()
                .immutable()
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
                .immutable()
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected()
                .weightRange(1, 50)
                .generate();
    }

    public static IGraph weightedGraph(int vertices) {

        return Graphs.random()
                .immutable()
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected()
                .weightRange(1, 50)
                .generate();
    }

    public static IGraph directedGraph(int vertices) {

        return Graphs.random()
                .immutable()
                .directed()
                .vertices(vertices)
                .edges(vertices * 2)
                .generate();
    }

    public static IGraph sparseGraph(int vertices) {

        return Graphs.random()
                .immutable()
                .undirected()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected()
                .generate();
    }

    public static IGraph directedSparseGraph(int vertices) {

        return Graphs.random()
                .immutable()
                .directed()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected()
                .generate();
    }

    public static IGraph treeGraph(int vertices) {

        return Graphs.random()
                .immutable()
                .undirected()
                .vertices(vertices)
                .edges(vertices - 1)
                .connected()
                .generate();
    }

    public static IGraph dag(int vertices) {

        return Graphs.patterns().dag(vertices);
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

}
