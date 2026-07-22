package main.java.io.graphite.exception.graph;

import main.java.io.graphite.exception.GraphException;
import main.java.io.graphite.algorithm.mst.Kruskal;
import main.java.io.graphite.algorithm.mst.Prim;

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
