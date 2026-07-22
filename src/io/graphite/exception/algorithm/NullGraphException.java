package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;

/**
 * Thrown when a required graph reference is {@code null}.
 *
 * <p>This exception is raised when a graph operation or algorithm receives
 * a {@code null} graph instead of a valid graph instance.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see io.graphite.validation.GraphPreconditions
 * @since 2.0
 */
public class NullGraphException extends GraphException {
    public NullGraphException() {
        super("Graph cannot be null.");
    }
}
