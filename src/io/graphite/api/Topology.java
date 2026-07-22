package io.graphite.api;

import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.TopologicalSortResult;

/**
 * Provides topological ordering algorithms.
 *
 * <p>The {@code Topology} service computes a valid topological ordering
 * of directed acyclic graphs (DAGs). If the graph contains a cycle,
 * an exception is thrown.</p>
 *
 * <pre>{@code
 * TraversalResult order =
 *         graph.topology().topologicalSort();
 * }</pre>
 *
 * <h2>Available Algorithms</h2>
 * <ul>
 *     <li>DFS Topological Sort</li>
 *     <li>Kahn's Algorithm</li>
 * </ul>
 *
 * <h2>Typical Applications</h2>
 * <ul>
 *     <li>Task scheduling</li>
 *     <li>Dependency resolution</li>
 *     <li>Build systems</li>
 *     <li>Course prerequisite planning</li>
 * </ul>
 *
 * @author Chinmay
 * @version 2.0
 * @see DFSTopologicalSort
 * @see KahnTopologicalSort
 * @see IGraph#topology()
 * @since 2.0
 */
public final class Topology extends GraphAPI {
    public Topology(IGraph graph) {
        super(graph);
    }

    public TopologicalSortResult dfs() {
        return DFSTopologicalSort.INSTANCE.sort(graph);
    }

    public TopologicalSortResult kahn() {
        return KahnTopologicalSort.INSTANCE.sort(graph);
    }
}
