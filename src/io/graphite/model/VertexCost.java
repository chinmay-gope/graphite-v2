package io.graphite.model;

public record VertexCost(int vertex, int cost)
        implements Comparable<VertexCost> {

    @Override
    public int compareTo(VertexCost other) {
        return Integer.compare(cost, other.cost);
    }
}
