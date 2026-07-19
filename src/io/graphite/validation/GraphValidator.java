package io.graphite.validation;

import io.graphite.exception.algorithm.NullGraphException;
import io.graphite.exception.graph.InvalidVertexException;
import io.graphite.graph.DirectedGraph;
import io.graphite.graph.IGraph;
import io.graphite.graph.UndirectedGraph;
import io.graphite.model.Edge;

public final class GraphValidator {
    private GraphValidator() {
        throw new AssertionError("No GraphValidator instances for you!");
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
        if (!(graph instanceof DirectedGraph)) {
            throw new UnsupportedOperationException(
                    "Directed graph required."
            );
        }
    }

    public static void requireUndirected(IGraph graph) {
        if (!(graph instanceof UndirectedGraph)) {
            throw new UnsupportedOperationException(
                    "Undirected graph required."
            );
        }
    }

    public static void requireWeighted(IGraph graph) {
        if (!graph.isWeighted()) {
            throw new UnsupportedOperationException(
                    "Weighted graph required."
            );
        }
    }
}
