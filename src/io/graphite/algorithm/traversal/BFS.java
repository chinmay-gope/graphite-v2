package io.graphite.algorithm.traversal;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.TraversalResult;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS extends GraphAlgorithm implements TraversalAlgorithm {
    @Override
    public TraversalResult traverse(IGraph graph, int source) {

        validate(graph);
        validateVertex(graph, source);

        boolean[] visited = booleans(graph);

        Queue<Integer> queue = new ArrayDeque<>();

        List<Integer> traversalOrder = new ArrayList<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            traversalOrder.add(current);

            for (Edge edge : neighbours(graph, current)) {
                int neighbor = edge.destination();

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return new TraversalResult(source, traversalOrder);
    }
}
