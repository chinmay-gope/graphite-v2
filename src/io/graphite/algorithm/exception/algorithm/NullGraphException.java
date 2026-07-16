package io.graphite.algorithm.exception.algorithm;

import io.graphite.algorithm.exception.GraphException;

public class NullGraphException extends GraphException {
    public NullGraphException() {
        super("Graph cannot be null.");
    }
}
