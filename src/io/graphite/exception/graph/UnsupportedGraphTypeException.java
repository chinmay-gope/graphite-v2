package io.graphite.exception.graph;

import io.graphite.exception.GraphException;

public class UnsupportedGraphTypeException extends GraphException {
    public UnsupportedGraphTypeException(boolean expectedDirected,
                                         boolean actualDirected) {
        super("Expected a "
                + (expectedDirected ? "directed" : "undirected")
                + " graph, but found a "
                + (actualDirected ? "directed" : "undirected")
                + " graph.");
    }
}
