package io.graphite.algorithm.result;

import io.graphite.algorithm.euler.EulerType;

import java.util.List;

public record EulerResult(
        EulerType type,
        List<Integer> traversal) {

    public EulerResult {
        traversal = List.copyOf(traversal);
    }

    @Override
    public List<Integer> traversal() {
        return List.copyOf(traversal);
    }

    @Override
    public String toString() {
        return type + ": " + traversal;
    }
}
