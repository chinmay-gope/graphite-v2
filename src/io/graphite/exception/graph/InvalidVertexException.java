package io.graphite.exception.graph;

import io.graphite.exception.GraphException;

/**
 * Thrown when a vertex identifier is outside the valid range of a graph.
 *
 * <p>This exception is raised whenever an algorithm or graph operation
 * attempts to access a vertex that does not exist.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see io.graphite.validation.GraphPreconditions
 * @since 2.0
 */
public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
