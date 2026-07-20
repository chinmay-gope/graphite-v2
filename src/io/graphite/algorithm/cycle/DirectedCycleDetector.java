package io.graphite.algorithm.cycle;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.validation.GraphPreconditions;

public class DirectedCycleDetector extends GraphAlgorithm implements CycleDetectionAlgorithm {

    private DirectedCycleDetector() {
    }

    public static DirectedCycleDetector INSTANCE = new DirectedCycleDetector();

    @Override
    public boolean hasCycle(IGraph graph) {
        GraphPreconditions.requireGraph(graph);

        boolean[] visited = booleans(graph);
        boolean[] recursionStack = booleans(graph);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(IGraph graph, int current, boolean[] visited, boolean[] recursionStack) {
        visited[current] = true;
        recursionStack[current] = true;

        for (Edge edge : neighbours(graph, current)) {
            int neighbor = edge.destination();

            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true;
            }
        }

        recursionStack[current] = false;
        return false;
    }
}
