package io.graphite.exception.graph;

import io.graphite.exception.GraphException;

public class ImmutableGraphException extends GraphException {
    public ImmutableGraphException() {
        super("Graph is immutable and cannot be modified.");
    }
}
