package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;
import io.graphite.validation.GraphPreconditions;

/**
 * Thrown when an algorithm is executed on an incompatible graph type.
 *
 * <p>This exception is raised when an algorithm requires either a directed
 * or an undirected graph but receives the opposite graph type.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphPreconditions
 * @since 2.0
 */
public class UnsupportedWeightedGraphException extends GraphException {
    public UnsupportedWeightedGraphException() {
        super("Weighted graph required.");
    }
}
