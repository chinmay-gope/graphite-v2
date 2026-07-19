package io.graphite.algorithm;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.validation.GraphValidator;

import java.util.Arrays;
import java.util.List;

public abstract class GraphAlgorithm {
    // ==========================================================
    // Validation
    // ==========================================================

    protected final void validate(IGraph graph) {
        GraphValidator.validate(graph);
    }

    protected final void requireDirected(IGraph graph) {
        GraphValidator.requireDirected(graph);
    }

    protected final void requireUndirected(IGraph graph) {
        GraphValidator.requireUndirected(graph);
    }

    protected final void requireWeighted(IGraph graph) {
        GraphValidator.requireWeighted(graph);
    }

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

    protected void validateVertex(IGraph graph, int vertex) {
        GraphValidator.validateVertex(graph, vertex);
    }
}
