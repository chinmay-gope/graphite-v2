package io.graphite.algorithm.topology;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.cycle.CycleDetectionAlgorithm;
import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.algorithm.exception.algorithm.GraphCycleException;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.result.TopologicalSortResult;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFSTopologicalSort extends GraphAlgorithm implements TopologicalAlgorithm {
    @Override
    public TopologicalSortResult sort(IGraph graph) {
        validate(graph);
        requireUndirected(graph);

        CycleDetectionAlgorithm detector = new DirectedCycleDetector();

        if (detector.hasCycle(graph)) {
            throw new GraphCycleException("Topological sort requires a Directed Acyclic Graph (DAG).");
        }

        boolean[] visited = booleans(graph);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                topo(graph, i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return new TopologicalSortResult(result);
    }

    private void topo(IGraph graph, int i, boolean[] visited, Deque<Integer> stack) {
        visited[i] = true;
        for (Edge edge : neighbours(graph, i)) {
            int neighbor = edge.destination();
            if (!visited[neighbor]) {
                topo(graph, neighbor, visited, stack);
            }
        }
        stack.push(i);
    }
}
