package io.graphite.util;

import io.graphite.algorithm.traversal.DFS;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.TraversalResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GraphUtils {
    private GraphUtils() {
    }

    public static boolean isConnected(IGraph graph) {
        int start = -1;

        for (int i = 0; i < graph.getVertices(); i++) {
            if (graph.degree(i) > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return true;
        }

        TraversalResult result = DFS.INSTANCE.traverse(graph, start);

        Set<Integer> visited = new HashSet<>(result.traversalOrder());

        for (int i = 0; i < graph.getVertices(); i++) {

            if (graph.degree(i) > 0 && !visited.contains(i)) {
                return false;
            }
        }

        return true;
    }

    public static Edge getFirstNeighbour(IGraph graph, int vertex) {
        List<Edge> edgeList = graph.neighbors(vertex);

        if (edgeList.isEmpty()) {
            return null;
        }

        return edgeList.getFirst();
    }
}
