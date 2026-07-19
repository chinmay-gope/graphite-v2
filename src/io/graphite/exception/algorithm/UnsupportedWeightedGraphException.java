package io.graphite.exception.algorithm;

import io.graphite.exception.GraphException;

public class UnsupportedWeightedGraphException extends GraphException {
    public UnsupportedWeightedGraphException() {
        super("Weighted graph required.");
    }
}
