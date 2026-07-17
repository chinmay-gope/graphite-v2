package io.graphite.algorithm.topology;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.exception.algorithm.GraphCycleException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.TopologicalSortResult;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopologicalSort extends GraphAlgorithm implements TopologicalAlgorithm {
    @Override
    public TopologicalSortResult sort(IGraph graph) {
        validate(graph);
        requireDirected(graph);

        int vertices = graph.getVertices();

        int[] indegree = ints(graph, 0);
//        Step 1:Calculate indegree of every vertex
        for (int u = 0; u < vertices; u++) {
            indegree[u] = 0;
            for (Edge edge : graph.getAdjacencyList().get(u)) {
                indegree[edge.destination()]++;
            }
        }
//        Step 2: Add all vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new LinkedList<>();

//         Step 3: Queue Processing
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (Edge edge : graph.getAdjacencyList().get(u)) {
                indegree[edge.destination()]--;

                if (indegree[edge.destination()] == 0) {
                    queue.add(edge.destination());
                }

            }
        }

//         Step 4: Cycle detection
        if (order.size() != vertices) {
            throw new GraphCycleException();
        }

        return new TopologicalSortResult(order);
    }
}
