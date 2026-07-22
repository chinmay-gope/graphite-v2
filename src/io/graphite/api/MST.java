package io.graphite.api;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.MSTResult;

/**
 * Provides Minimum Spanning Tree (MST) algorithms.
 *
 * <p>The {@code MST} service computes a minimum spanning tree for connected,
 * weighted, undirected graphs. A minimum spanning tree connects every vertex
 * using the minimum possible total edge weight without forming cycles.</p>
 *
 * <pre>{@code
 * MSTResult result = graph.mst().prim();
 *
 * MSTResult result = graph.mst().kruskal();
 * }</pre>
 *
 * <h2>Available Algorithms</h2>
 * <ul>
 *     <li>Prim's Algorithm</li>
 *     <li>Kruskal's Algorithm</li>
 * </ul>
 *
 * <h2>Typical Applications</h2>
 * <ul>
 *     <li>Network design</li>
 *     <li>Road and utility planning</li>
 *     <li>Infrastructure optimization</li>
 *     <li>Hierarchical clustering</li>
 * </ul>
 *
 * <p>This service delegates execution to stateless singleton algorithm
 * implementations.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see Prim
 * @see Kruskal
 * @see MSTResult
 * @see IGraph#mst()
 * @since 2.0
 */
public final class MST extends GraphAPI {
    public MST(IGraph graph) {
        super(graph);
    }

    public MSTResult prim(int source) {
        return  Prim.INSTANCE.findMST(graph, source);
    }

    public MSTResult kruskal() {
        return  Kruskal.INSTANCE.findMST(graph);
    }
}
