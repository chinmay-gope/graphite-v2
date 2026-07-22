package main.java.io.graphite.exception.algorithm;

import main.java.io.graphite.exception.GraphException;
import main.java.io.graphite.algorithm.shortestpath.BellmanFord;

/**
 * Thrown when a graph contains a reachable negative-weight cycle.
 *
 * <p>Shortest paths are undefined in the presence of negative-weight
 * cycles, preventing algorithms such as Bellman-Ford from producing a
 * valid result.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see BellmanFord
 * @since 2.0
 */
public class NegativeCycleException extends GraphException {
    public NegativeCycleException() {
        super("The graph contains a negative weight cycle.");
    }
}
