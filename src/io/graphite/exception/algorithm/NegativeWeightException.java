package io.graphite.exception.algorithm;

import io.graphite.algorithm.exception.GraphException;

public class NegativeWeightException extends GraphException {
    public NegativeWeightException(String message) {
        super(message);
    }
}
