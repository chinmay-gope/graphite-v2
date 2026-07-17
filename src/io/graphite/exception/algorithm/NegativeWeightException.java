package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;

public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
