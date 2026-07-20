package io.graphite.builder;

import io.graphite.generator.RandomGraphBuilder;
import io.graphite.generator.pattern.*;
import io.graphite.graph.IGraph;
import io.graphite.io.reader.GraphReaderService;

public final class Graphs {

    public static GraphReaderService read() {
        return new GraphReaderService();
    }

    private Graphs() {
    }

    // Builders
    public static DirectedGraphBuilder directed() {
        return new DirectedGraphBuilder();
    }

    public static UndirectedGraphBuilder undirected() {
        return new UndirectedGraphBuilder();
    }

    public static RandomGraphBuilder random() {
        return new RandomGraphBuilder();
    }

    // Patterns
    public static IGraph complete(int vertices) {
        return CompleteGraphGenerator.generate(vertices);
    }

    public static IGraph cycle(int vertices) {
        return CycleGraphGenerator.generate(vertices);
    }

    public static IGraph dag(int vertices) {
        return DAGGenerator.generate(vertices, vertices * 2);
    }

    public static IGraph completeBipartite(int left, int right) {
        return CompleteBipartiteGraphGenerator.generate(left, right);
    }

    public static IGraph tree(int vertices) {
        return TreeGraphGenerator.generate(vertices);
    }

    public static IGraph star(int vertices) {
        return StarGraphGenerator.generate(vertices);
    }

    public static IGraph wheel(int vertices) {
        return WheelGraphGenerator.generate(vertices);
    }

    public static IGraph grid(int rows, int cols) {
        return GridGraphGenerator.generate(rows, cols);
    }

    public static IGraph bipartite(int left, int right) {
        return BipartiteGraphGenerator.generate(left, right, left + right);
    }
}
