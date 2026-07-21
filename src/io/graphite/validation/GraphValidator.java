package io.graphite.validation;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class GraphValidator {
    private GraphValidator() {
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
}
