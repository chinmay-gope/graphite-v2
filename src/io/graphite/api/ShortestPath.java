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
     * @throws io.graphite.exception.graph.InvalidVertexException if the source vertex is invalid
     * @throws io.graphite.exception.algorithm.NegativeWeightException if the graph contains negative edge weights
     *  @see #bellmanFord(int)
     *  @see #floydWarshall()
     *  @since 2.0
     */
    public ShortestPathResult dijkstra(int source) {
        return Dijkstra.INSTANCE.shortestPath(graph, source);
    }

    /**
     * Computes shortest paths using the Bellman-Ford algorithm.
     *
     * <p>Unlike Dijkstra's algorithm, Bellman-Ford supports negative edge
     * weights and detects reachable negative-weight cycles.</p>
     *
     * <h2>Complexity</h2>
     *
     * <ul>
     *     <li>Time: O(VE)</li>
     *     <li>Space: O(V)</li>
     * </ul>
     *
     * @param source the source vertex
     * @return the computed shortest path result
     * @throws io.graphite.exception.algorithm.NullGraphException     if graph is null
     * @throws io.graphite.exception.graph.InvalidVertexException     if  vertex is invalid
     * @throws io.graphite.exception.algorithm.NegativeCycleException if the graph contains negative weight cycles
     * @see #dijkstra(int)
     * @since 2.0
     */
    public ShortestPathResult bellmanFord(int source) {
        return BellmanFord.INSTANCE.shortestPath(graph, source);
    }

    /**
     * Computes the shortest paths between every pair of vertices using
     * the Floyd-Warshall algorithm.
     *
     * <p>This algorithm computes all-pairs shortest paths and supports
     * graphs containing negative edge weights, provided there are no
     * negative-weight cycles.</p>
     *
     * <h2>Complexity</h2>
     *
     * <ul>
     *     <li>Time: O(V³)</li>
     *     <li>Space: O(V²)</li>
     * </ul>
     *
     * @return {@link AllPairsShortestPathResult}
     * @throws io.graphite.exception.algorithm.NegativeCycleException if the graph contains negative weight cycles
     * @see #dijkstra(int)
     * @see #bellmanFord(int)
     * @since 2.0
     */
    public AllPairsShortestPathResult floydWarshall() {
        return FloydWarshall.INSTANCE.shortestPaths(graph);
    }
}
