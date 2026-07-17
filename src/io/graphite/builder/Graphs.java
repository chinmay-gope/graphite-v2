package io.graphite.builder;

public final class Graphs {
    private Graphs() {
        throw new AssertionError("Utility class");
    }

    public static DirectedGraphBuilder directed() {
        return new DirectedGraphBuilder();
    }

    public static UndirectedGraphBuilder undirected() {
        return new UndirectedGraphBuilder();
    }
}
