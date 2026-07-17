package io.graphite.algorithm.traversal;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.TraversalResult;

import java.util.ArrayList;
import java.util.List;

public class DFS extends GraphAlgorithm implements TraversalAlgorithm {

    @Override
    public TraversalResult traverse(IGraph graph, int source) {
        validate(graph);
        validateVertex(graph, source);

        boolean[] visited = booleans(graph);

        List<Integer> traversalOrder = new ArrayList<>();

        dfs(graph, source, visited, traversalOrder);

        return new TraversalResult(source, traversalOrder);
    }

    private void dfs(IGraph graph,
                     int source,
                     boolean[] visited,
                     List<Integer> traversalOrder) {
        visited[source] = true;
        traversalOrder.add(source);

        for (Edge edge : neighbours(graph, source)) {
            int neighbor = edge.destination();

            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, traversalOrder);
            }
        }
    }
}
