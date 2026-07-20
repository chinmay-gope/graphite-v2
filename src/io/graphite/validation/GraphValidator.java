package io.graphite.validation;

import io.graphite.exception.algorithm.NullGraphException;
import io.graphite.exception.algorithm.UnsupportedWeightedGraphException;
import io.graphite.exception.graph.InvalidVertexException;
import io.graphite.exception.graph.UnsupportedGraphTypeException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class GraphValidator {
    private GraphValidator() {
    }

    public static boolean isEmpty(IGraph graph) {
        return graph.isEmpty();
    }

    public static boolean hasSelfLoop(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbors(i)) {

                if (i == edge.destination()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNegativeEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbors(i)) {
                if (edge.weight() < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void validateVertex(IGraph graph, int vertex) {
        validate(graph);

        if (vertex < 0 || vertex >= graph.getVertices()) {
            throw new InvalidVertexException(vertex);
        }
    }

    public static void validate(IGraph graph) {
        if (graph == null) {
            throw new NullGraphException();
        }
    }

    public static void requireDirected(IGraph graph) {
        validate(graph);
        if (!graph.isDirected()) {
            throw new UnsupportedGraphTypeException(
                    true,
                    graph.isDirected());
        }
    }

    public static void requireUndirected(IGraph graph) {
        validate(graph);

        if (!graph.isUndirected()) {
            throw new UnsupportedGraphTypeException(
                    false,
                    graph.isDirected());
        }
    }

    public static void requireWeighted(IGraph graph) {
        if (!graph.isWeighted()) {
            throw new UnsupportedWeightedGraphException();
        }
    }
}
