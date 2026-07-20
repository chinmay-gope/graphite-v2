package io.graphite.validation;

import io.graphite.exception.algorithm.NegativeWeightException;
import io.graphite.exception.algorithm.NullGraphException;
import io.graphite.exception.algorithm.UnsupportedWeightedGraphException;
import io.graphite.exception.graph.InvalidVertexException;
import io.graphite.exception.graph.UnsupportedGraphTypeException;
import io.graphite.graph.IGraph;

public final class GraphPreconditions {

    private GraphPreconditions() {
    }

    public static void requireGraph(IGraph graph) {

        if (graph == null) {
            throw new NullGraphException();
        }
    }

    public static void requireVertex(
            IGraph graph,
            int vertex) {

        requireGraph(graph);

        if (vertex < 0 || vertex >= graph.getVertices()) {
            throw new InvalidVertexException(vertex);
        }
    }

    public static void requireDirected(
            IGraph graph) {

        requireGraph(graph);

        if (!graph.isDirected()) {
            throw new UnsupportedGraphTypeException(
                    true,
                    graph.isDirected());
        }
    }

    public static void requireUndirected(
            IGraph graph) {

        requireGraph(graph);

        if (!graph.isUndirected()) {
            throw new UnsupportedGraphTypeException(
                    false,
                    graph.isDirected());
        }
    }

    public static void requireWeighted(
            IGraph graph) {

        requireGraph(graph);

        if (!graph.isWeighted()) {
            throw new UnsupportedWeightedGraphException();
        }
    }

    public static void requireNonNegative(
            IGraph graph) {

        requireGraph(graph);

        if (GraphValidator.hasNegativeEdges(graph)) {
            throw new NegativeWeightException("Algorithm cannot be applied to graphs with negative edge weights.");
        }
    }
}
