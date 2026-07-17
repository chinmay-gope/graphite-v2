package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;

public class GraphCycleException extends GraphException {
    public GraphCycleException() {
        super("The graph contains one or more cycles.");
    }

    public GraphCycleException(String message) {
        super(message);
    }
}
