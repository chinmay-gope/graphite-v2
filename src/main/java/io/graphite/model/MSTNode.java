package main.java.io.graphite.model;

public record MSTNode(
        int parent,
        int vertex,
        int weight
) implements Comparable<MSTNode> {
    @Override
    public int compareTo(MSTNode other) {
        return Integer.compare(weight, other.weight());
    }
}
