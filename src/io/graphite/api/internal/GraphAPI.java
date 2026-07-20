package io.graphite.api.internal;

import io.graphite.api.*;
import io.graphite.graph.IGraph;

/**
 * Base class for all Graphite API services.
 * <p>
 * A {@code GraphAPI} provides a high-level, user-friendly API over one or
 * more graph algorithms while holding a reference to the target graph.
 * Concrete services expose operations such as traversal, shortest paths,
 * minimum spanning trees, connectivity analysis, and more.
 * <p>
 * Users should obtain service instances through the graph API rather than
 * creating them directly.
 *
 * @see Bipartite
 * @see Connectivity
 * @see Cycle
 * @see Euler
 * @see MST
 * @see ShortestPath
 * @see Traversal
 * @see Topology
 */
public abstract class GraphAPI {

    /**
     * The graph associated with this service.
     */
    protected final IGraph graph;

    /**
     * Creates a service bound to the specified graph.
     * <p>
     * This constructor is intended to be invoked only by subclasses.
     * Concrete service constructors should remain package-private so that
     * service instances are created exclusively through the graph API
     * (for example, {@code graph.traversal()} or {@code graph.mst()}).
     *
     * @param graph the graph this service operates on
     */
    protected GraphAPI(IGraph graph) {
        this.graph = graph;
    }
}
