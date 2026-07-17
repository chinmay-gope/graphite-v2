package io.graphite.exception.algorithm;

import io.graphite.algorithm.exception.GraphException;

public class NegativeCycleException extends GraphException {
    public NegativeCycleException() {
        super("The graph contains a negative weight cycle.");
    }
}
