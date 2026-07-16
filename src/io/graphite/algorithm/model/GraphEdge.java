package io.graphite.algorithm.model;

public record GraphEdge(
        int source,
        int destination,
        int weight
) {
}
