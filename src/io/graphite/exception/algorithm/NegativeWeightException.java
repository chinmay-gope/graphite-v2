package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;

/**
 * Thrown when an algorithm that requires non-negative edge weights
 * encounters a negative-weight edge.
 *
 * <p>This exception is commonly raised by Dijkstra's shortest path
 * algorithm.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see io.graphite.algorithm.shortestpath.Dijkstra
 * @since 2.0
 */
public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
