package io.graphite.exception.graph;

import io.graphite.exception.GraphException;

public class InvalidVertexException extends GraphException {
    public InvalidVertexException(int vertex) {
        super("Invalid vertex " + vertex);
    }
}
