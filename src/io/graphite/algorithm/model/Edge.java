package io.graphite.algorithm.model;

public record Edge(
        int source,
        int destination,
        int weight
) {
    @Override
    public String toString() {
        return source + " -> " + destination + " (" + weight + ")";
    }
}
