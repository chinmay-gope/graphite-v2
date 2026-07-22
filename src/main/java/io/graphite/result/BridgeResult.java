package main.java.io.graphite.result;

import main.java.io.graphite.model.Edge;

import java.util.List;

public record BridgeResult(List<Edge> bridges) implements Colors {
    public BridgeResult {
        bridges = List.copyOf(bridges);
    }

    @Override
    public List<Edge> bridges() {
        return List.copyOf(bridges);
    }

    public int count() {
        return bridges.size();
    }

    public boolean isEmpty() {
        return bridges.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Edge edge : bridges) {
            int source = edge.source();
            int destination = edge.destination();
            builder.append(CYAN)
                    .append("Bridge: ")
                    .append(RESET)
                    .append(MAGENTA)
                    .append(source)
                    .append((" -- "))
                    .append(destination)
                    .append(RESET)
                    .append('\n');
        }
        return builder.toString();
    }
}
