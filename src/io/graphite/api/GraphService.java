package io.graphite.api;

import io.graphite.graph.IGraph;

/**
 * Base class for all Graphite API services.
 * <p>
 * A {@code GraphService} provides a high-level, user-friendly API over one or
 * more graph algorithms while holding a reference to the target graph.
 * Concrete services expose operations such as traversal, shortest paths,
 * minimum spanning trees, connectivity analysis, and more.
 * <p>
 * Users should obtain service instances through the graph API rather than
 * creating them directly.
 *
 * @see BipartiteService
 * @see ConnectivityService
 * @see EulerService
 * @see MSTService
 * @see ShortestPathService
 * @see TraversalService
 * @see TopologyService
 */
public abstract class GraphService {

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
    protected GraphService(IGraph graph) {
        this.graph = graph;
    }
}
