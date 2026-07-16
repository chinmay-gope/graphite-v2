package io.graphite.algorithm.validation;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.exception.graph.InvalidVertexException;
import io.graphite.algorithm.exception.algorithm.NullGraphException;
import io.graphite.algorithm.model.Edge;

public final class GraphValidator {
    private GraphValidator() {
        throw new AssertionError("No GraphValidator instances for you!");
    }

    public static boolean isEmpty(IGraph graph) {
        return graph.isEmpty();
    }

    public static boolean hasSelfLoop(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {

                if (i == edge.destination()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasWeightedEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                if (edge.weight() != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNegativeEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                if (edge.weight() < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void validateVertex(IGraph graph, int vertex) {
        if (graph == null) {
            throw new NullGraphException();
        }

        if (vertex < 0 || vertex >= graph.getVertices()) {
            throw new InvalidVertexException(vertex);
        }
    }
}
