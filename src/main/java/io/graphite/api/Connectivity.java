package main.java.io.graphite.api;

import main.java.io.graphite.algorithm.connectivity.APFinder;
import main.java.io.graphite.algorithm.connectivity.BiconnectedComponents;
import main.java.io.graphite.algorithm.connectivity.BridgeFinder;
import main.java.io.graphite.algorithm.connectivity.Kosaraju;
import main.java.io.graphite.api.internal.GraphAPI;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.APResult;
import main.java.io.graphite.result.BiConnectedResult;
import main.java.io.graphite.result.BridgeResult;
import main.java.io.graphite.result.SCCResult;
import main.java.io.graphite.exception.algorithm.NullGraphException;
import main.java.io.graphite.exception.graph.UnsupportedGraphTypeException;

/**
 * Provides graph connectivity algorithms.
 *
 * <p>The {@code Connectivity} service analyzes the structural connectivity
 * of graphs, including connected components, strongly connected components,
 * bridges, articulation points, and biconnected components.</p>
 *
 * <pre>{@code
 * graph.connectivity().connectedComponents();
 *
 * graph.connectivity().stronglyConnectedComponents();
 *
 * graph.connectivity().bridges();
 * }</pre>
 *
 * <h2>Available Algorithms</h2>
 * <ul>
 *     <li>Connected Components</li>
 *     <li>Strongly Connected Components (Kosaraju)</li>
 *     <li>Bridge Detection</li>
 *     <li>Articulation Points</li>
 *     <li>Biconnected Components</li>
 * </ul>
 *
 * <h2>Typical Applications</h2>
 * <ul>
 *     <li>Network reliability</li>
 *     <li>Critical infrastructure analysis</li>
 *     <li>Dependency analysis</li>
 *     <li>Social network analysis</li>
 * </ul>
 *
 * @author Chinmay
 * @version 2.0
 * @see Kosaraju
 * @see BridgeFinder
 * @see APFinder
 * @see BiconnectedComponents
 * @see IGraph#connectivity()
 * @since 2.0
 */
public final class Connectivity extends GraphAPI {

    public Connectivity(IGraph graph) {
        super(graph);
    }


    public APResult articulationPoints() {
        return APFinder.INSTANCE.findArticulationPoints(graph);
    }

    /**
     * Identifies all bridges in the graph.
     *
     * <p>A bridge is an edge whose removal increases the number of connected
     * components in the graph.</p>
     *
     * <p>This algorithm is applicable only to undirected graphs.</p>
     *
     * <h2>Complexity</h2>
     *
     * <ul>
     *     <li>Time: O(V + E)</li>
     *     <li>Space: O(V)</li>
     * </ul>
     *
     * @return all bridge edges
     * @throws NullGraphException        if the graph is {@code null}
     * @throws UnsupportedGraphTypeException if the graph is directed
     * @since 2.0
     */
    public BridgeResult bridges() {
        return BridgeFinder.INSTANCE.findBridges(graph);
    }

    /**
     * Computes the connected components of an undirected graph.
     *
     * <p>A connected component is a maximal set of vertices in which every
     * vertex is reachable from every other vertex.</p>
     *
     * <p>This algorithm is applicable only to undirected graphs.</p>
     *
     * <h2>Complexity</h2>
     *
     * <ul>
     *     <li>Time: O(V + E)</li>
     *     <li>Space: O(V)</li>
     * </ul>
     *
     * @return the connected components of the graph
     * @throws NullGraphException        if the graph is {@code null}
     * @throws UnsupportedGraphTypeException if the graph is directed
     * @see #stronglyConnectedComponents()
     * @since 2.0
     */
    public BiConnectedResult biconnectedComponents() {
        return BiconnectedComponents.INSTANCE.findBiconnectedComponents(graph);
    }

    /**
     * Computes the strongly connected components (SCCs) of a directed graph
     * using Kosaraju's algorithm.
     *
     * <p>A strongly connected component is a maximal set of vertices in
     * which every vertex is reachable from every other vertex.</p>
     *
     * <p>This algorithm is applicable only to directed graphs.</p>
     *
     * <h2>Complexity</h2>
     *
     * <ul>
     *     <li>Time: O(V + E)</li>
     *     <li>Space: O(V)</li>
     * </ul>
     *
     * @return the strongly connected components
     * @throws NullGraphException        if the graph is {@code null}
     * @throws UnsupportedGraphTypeException if the graph is undirected
     * @see #biconnectedComponents()
     * @since 2.0
     */
    public SCCResult stronglyConnectedComponents() {
        return Kosaraju.INSTANCE.findSCCs(graph);
    }
}
