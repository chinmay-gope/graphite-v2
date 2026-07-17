package io.graphite.result;

public record MSTEdge(
        int source,
        int destination,
        int weight
) {

    @Override
    public String toString() {
        return String.format("%d ──(%d)──> %d", source, weight, destination);
    }
}
