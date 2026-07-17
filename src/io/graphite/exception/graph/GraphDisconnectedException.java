package io.graphite.exception.graph;

import io.graphite.algorithm.exception.GraphException;

public class GraphDisconnectedException extends GraphException {
    public GraphDisconnectedException(String message) {
        super(message);
    }
}
