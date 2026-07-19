package io.graphite.exception.graph;

import io.graphite.exception.GraphException;

public class InvalidGraphConfigurationException extends GraphException {
    public InvalidGraphConfigurationException(String message) {
        super(message);
    }
}
