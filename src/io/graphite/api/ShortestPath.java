package io.graphite.api;

import io.graphite.algorithm.shortestpath.BellmanFord;
import io.graphite.algorithm.shortestpath.Dijkstra;
import io.graphite.algorithm.shortestpath.FloydWarshall;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.AllPairsShortestPathResult;
import io.graphite.result.ShortestPathResult;

/**
 * Provides shortest path algorithms.
 *
 * <p>The {@code ShortestPath} service computes minimum-cost paths between
 * vertices in weighted and unweighted graphs.</p>
 *
 * <p>Algorithms are selected explicitly by the caller depending on graph
 * characteristics such as edge weights and graph density.</p>
 *
 * <pre>{@code
 * ShortestPathResult result =
 *         graph.shortestPath().dijkstra(0);
 * }</pre>
 *
 * <h2>Available Algorithms</h2>
 *
 * <ul>
 *     <li>Dijkstra</li>
 *     <li>Bellman-Ford</li>
 *     <li>Floyd-Warshall</li>
 * </ul>
 *
 * <h2>Typical Applications</h2>
 *
 * <ul>
 *     <li>Network optimization</li>
 *     <li>Navigation systems</li>
 *     <li>Dependency analysis</li>
 * </ul>
 *
 * @since 2.0
 */
public final class ShortestPath extends GraphAPI {
    public ShortestPath(IGraph graph) {
        super(graph);
    }

    /**
     * Computes shortest paths using Dijkstra's algorithm.
     *
     * <p>This algorithm requires all edge weights to be non-negative.</p>
     *
     * <p>Time Complexity:
     * O((V + E) log V)</p>
     *
     * @throws io.graphite.exception.algorithm.NegativeWeightException if the graph contains negative edge weights
     */
    public ShortestPathResult dijkstra(int source) {
        return Dijkstra.INSTANCE.shortestPath(graph, source);
    }

    public ShortestPathResult bellmanFord(int source) {
        return BellmanFord.INSTANCE.shortestPath(graph, source);
    }

    public AllPairsShortestPathResult floydWarshall() {
        return FloydWarshall.INSTANCE.shortestPaths(graph);
    }
}
