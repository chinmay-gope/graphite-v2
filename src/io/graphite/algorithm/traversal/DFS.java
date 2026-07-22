package io.graphite.algorithm.traversal;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.TraversalResult;
import io.graphite.validation.GraphPreconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Depth-First Search (DFS) graph traversal algorithm.
 *
 * <p>Depth-First Search explores a graph by following one branch as far as
 * possible before backtracking. It forms the basis of numerous graph
 * algorithms including cycle detection, topological sorting, bridge
 * detection, articulation point discovery, and strongly connected
 * components.</p>
 *
 * <h2>Requirements</h2>
 *
 * <ul>
 *     <li>Supports directed and undirected graphs.</li>
 *     <li>The source vertex must exist.</li>
 * </ul>
 *
 * <h2>Algorithm Overview</h2>
 *
 * <p>This implementation performs recursive depth-first traversal while
 * maintaining a visited set to prevent revisiting vertices.</p>
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
 *     <li>Cycle detection</li>
 *     <li>Topological sorting</li>
 *     <li>Connectivity analysis</li>
 *     <li>Path discovery</li>
 * </ul>
 *
 * <h2>Implementation Notes</h2>
 *
 * <p>This implementation is stateless and exposed as a singleton through
 * {@code INSTANCE}.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see BFS
 * @see io.graphite.api.Traversal
 * @see TraversalResult
 * @since 2.0
 */
public class DFS extends GraphAlgorithm implements TraversalAlgorithm {
    public static final DFS INSTANCE = new DFS();

    private DFS() {
    }

    @Override
    public TraversalResult traverse(IGraph graph, int source) {
        GraphPreconditions.requireGraph(graph);
        GraphPreconditions.requireVertex(graph, source);

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
