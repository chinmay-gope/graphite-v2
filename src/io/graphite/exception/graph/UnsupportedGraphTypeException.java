package io.graphite.exception.graph;

import io.graphite.algorithm.exception.GraphException;

public class UnsupportedGraphTypeException extends GraphException {
    public UnsupportedGraphTypeException(GraphType expected,
                                         GraphType actual) {
        super("Expected graph type: " + expected +
                ", but found: " + actual + ".");
    }
}
