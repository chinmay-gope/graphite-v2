/**
 * Public service APIs for graph algorithms.
 *
 * <p>Rather than exposing algorithm implementations directly, Graphite
 * groups related algorithms into specialized service APIs.
 *
 * <p>Typical usage:
 *
 * <pre>{@code
 * graph.traversal().bfs(0);
 * graph.shortestPath().dijkstra(0);
 * graph.mst().prim();
 * graph.connectivity().bridges();
 * }</pre>
 *
 * <p>This approach keeps the public API compact, organized,
 * and easy to discover.
 *
 * @since 2.0
 */

package main.java.io.graphite.api;
