package io.graphite.api;

import io.graphite.algorithm.connectivity.APFinder;
import io.graphite.algorithm.connectivity.BiconnectedComponents;
import io.graphite.algorithm.connectivity.BridgeFinder;
import io.graphite.algorithm.connectivity.Kosaraju;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.APResult;
import io.graphite.result.BiConnectedResult;
import io.graphite.result.BridgeResult;
import io.graphite.result.SCCResult;

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

    public BridgeResult bridges() {
        return BridgeFinder.INSTANCE.findBridges(graph);
    }

    public BiConnectedResult biconnectedComponents() {
        return BiconnectedComponents.INSTANCE.findBiconnectedComponents(graph);
    }

    public SCCResult stronglyConnectedComponents() {
        return Kosaraju.INSTANCE.findSCCs(graph);
    }
}
