package io.graphite.exception.graph;

import io.graphite.exception.GraphException;
import io.graphite.validation.GraphPreconditions;

/**
 * Thrown when an operation is not supported for the supplied graph type.
 *
 * <p>This exception is raised when an algorithm requires either a directed
 * or an undirected graph, but the provided graph does not satisfy that
 * requirement.</p>
 *
 * <p>Examples include executing Topological Sort on an undirected graph or
 * computing a Minimum Spanning Tree on a directed graph.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphPreconditions
 * @since 2.0
 */
public class UnsupportedGraphTypeException extends GraphException {
    public UnsupportedGraphTypeException(boolean expectedDirected,
                                         boolean actualDirected) {
        super("Expected a "
                + (expectedDirected ? "directed" : "undirected")
                + " graph, but found a "
                + (actualDirected ? "directed" : "undirected")
                + " graph.");
    }
}
