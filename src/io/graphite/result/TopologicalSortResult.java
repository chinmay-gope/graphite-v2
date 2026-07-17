package io.graphite.result;

import java.util.List;

public record TopologicalSortResult(List<Integer> order) {
    public TopologicalSortResult {
        order = List.copyOf(order);
    }

    @Override
    public String toString() {
        return "Topological Order: " + order;
    }
}
