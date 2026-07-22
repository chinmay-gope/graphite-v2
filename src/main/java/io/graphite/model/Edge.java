package main.java.io.graphite.model;

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
