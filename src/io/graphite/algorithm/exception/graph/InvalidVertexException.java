package io.graphite.algorithm.exception.graph;

import io.graphite.algorithm.exception.GraphException;

public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
