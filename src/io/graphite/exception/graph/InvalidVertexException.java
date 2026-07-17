package io.graphite.exception.graph;

import io.graphite.algorithm.exception.GraphException;

public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
