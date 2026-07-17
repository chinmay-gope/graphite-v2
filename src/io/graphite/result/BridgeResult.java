package io.graphite.result;

import io.graphite.model.Edge;

import java.util.List;

import static io.graphite.result.Result.*;

public record BridgeResult(List<Edge> bridges) {
    public BridgeResult {
        bridges = List.copyOf(bridges);
    }

    @Override
    public List<Edge> bridges() {
        return List.copyOf(bridges);
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
