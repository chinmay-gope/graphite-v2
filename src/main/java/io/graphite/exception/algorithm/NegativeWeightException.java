package main.java.io.graphite.exception.algorithm;

import main.java.io.graphite.exception.GraphException;
import main.java.io.graphite.algorithm.shortestpath.Dijkstra;

/**
 * Thrown when an algorithm that requires non-negative edge weights
 * encounters a negative-weight edge.
 *
 * <p>This exception is commonly raised by Dijkstra's shortest path
 * algorithm.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see Dijkstra
 * @since 2.0
 */
public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
