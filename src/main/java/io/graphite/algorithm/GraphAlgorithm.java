package io.graphite.algorithm;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

import java.util.Arrays;
import java.util.List;

public abstract class GraphAlgorithm {
    // ==========================================================
    // Arrays
    // ==========================================================

    protected final boolean[] booleans(IGraph graph) {
        return new boolean[graph.getVertices()];
    }

    protected final int[] ints(
            IGraph graph,
            int defaultValue) {

        int[] array = new int[graph.getVertices()];
        Arrays.fill(array, defaultValue);

        return array;
    }

    // ==========================================================
    // Graph Views
    // ==========================================================

    protected final List<Edge> neighbours(IGraph graph, int vertex) {

        return graph.getNeighbors(vertex);
    }

    protected final List<Edge> edges(IGraph graph) {

        return graph.getEdges();
    }
}
