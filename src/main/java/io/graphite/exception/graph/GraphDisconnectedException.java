package io.graphite.exception.graph;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.exception.GraphException;

/**
 * Thrown when an algorithm requires a connected graph but the supplied
 * graph contains multiple disconnected components.
 *
 * <p>This exception is commonly raised by Minimum Spanning Tree algorithms
 * and other algorithms that assume graph connectivity.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see Prim
 * @see Kruskal
 * @since 2.0
 */
public class GraphDisconnectedException extends GraphException {
    public GraphDisconnectedException(String message) {
        super(message);
    }
}
