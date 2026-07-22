package io.graphite.exception.graph;

import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;

/**
 * Thrown when an attempt is made to modify an immutable graph.
 *
 * <p>This exception indicates that a mutating operation such as adding or
 * removing vertices or edges was invoked on a graph that has been marked
 * as immutable.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see IGraph
 * @since 2.0
 */
public class ImmutableGraphException extends GraphException {
    public ImmutableGraphException() {
        super("Graph is immutable and cannot be modified.");
    }
}
