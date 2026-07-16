package io.graphite.algorithm.exception.graph;

import io.graphite.algorithm.exception.GraphException;
import io.graphite.algorithm.graph.GraphType;

public class UnsupportedGraphTypeException extends GraphException {
    public UnsupportedGraphTypeException(GraphType expected,
                                         GraphType actual) {
        super("Expected graph type: " + expected +
                ", but found: " + actual + ".");
    }
}
