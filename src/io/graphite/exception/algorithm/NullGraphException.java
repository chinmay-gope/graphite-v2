package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;

public class NullGraphException extends GraphException {
    public NullGraphException() {
        super("Graph cannot be null.");
    }
}
