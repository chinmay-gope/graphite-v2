package io.graphite.algorithm.cycle;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.validation.GraphPreconditions;

/**
 * Detects cycles in undirected graphs.
 *
 * <p>This implementation performs a depth-first search while tracking the
 * parent of each visited vertex. A cycle exists whenever an already visited
 * neighbor is encountered that is not the current vertex's parent.</p>
 *
 * <h2>Requirements</h2>
 *
 * <ul>
 *     <li>The graph must be undirected.</li>
 * </ul>
 *
 * <h2>Algorithm Overview</h2>
 *
 * <p>Each connected component is explored using DFS. Parent tracking
 * distinguishes legitimate backtracking from actual cycles.</p>
 *
 * <h2>Complexity</h2>
 *
 * <ul>
 *     <li>Time: O(V + E)</li>
 *     <li>Space: O(V)</li>
 * </ul>
 *
 * <h2>Applications</h2>
 *
 * <ul>
 *     <li>Graph validation</li>
 *     <li>Tree verification</li>
 *     <li>Network analysis</li>
 * </ul>
 *
 * @author Chinmay
 * @version 2.0
 * @see DirectedCycleDetector
 * @see io.graphite.api.Cycle
 * @see io.graphite.algorithm.traversal.DFS
 * @since 2.0
 */
public class UndirectedCycleDetector extends GraphAlgorithm implements CycleDetectionAlgorithm {

    public static final UndirectedCycleDetector INSTANCE = new UndirectedCycleDetector();

    private UndirectedCycleDetector() {
    }

    @Override
    public boolean hasCycle(IGraph graph) {
        GraphPreconditions.requireGraph(graph);

        boolean[] visited = booleans(graph);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycle(
            IGraph graph,
            int current,
            int parent,
            boolean[] visited) {
        visited[current] = true;

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();

            if (!visited[neighbour]) {
                if (hasCycle(graph, neighbour, current, visited)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
