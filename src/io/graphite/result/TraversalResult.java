package io.graphite.result;

import java.util.List;

public record TraversalResult(int source, List<Integer> traversalOrder) implements Result {
    public TraversalResult {
        traversalOrder = List.copyOf(traversalOrder);
    }

    @Override
    public String toString() {
        return "TraversalResult{" +
                "source=" + GREEN + source + RESET +
                ", traversalOrder=" + MAGENTA + traversalOrder + RESET +
                '}';
    }
}
