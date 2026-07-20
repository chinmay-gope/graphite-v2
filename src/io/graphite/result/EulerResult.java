package io.graphite.result;

import io.graphite.algorithm.euler.EulerType;

import java.util.List;

public record EulerResult(
        EulerType type,
        List<Integer> traversal) {

    public EulerResult {
        traversal = List.copyOf(traversal);
    }

    public boolean isCircuit() {
        return type == EulerType.CIRCUIT;
    }

    public boolean isPath() {
        return type == EulerType.PATH;
    }

    public int start() {
        return traversal.getFirst();
    }

    public int end() {
        return traversal.getLast();
    }

    public int edgeCount() {
        return traversal.size() - 1;
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
