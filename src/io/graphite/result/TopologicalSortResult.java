package io.graphite.result;

import java.util.List;

public record TopologicalSortResult(List<Integer> order) {
    public TopologicalSortResult {
        order = List.copyOf(order);
    }

    public int size() {
        return order.size();
    }

    public boolean isEmpty() {
        return order.isEmpty();
    }

    public boolean contains(int vertex) {
        return order.contains(vertex);
    }

    public int first() {
        return order.getFirst();
    }

    public int last() {
        return order.getLast();
    }

    @Override
    public String toString() {
        return "Topological Order: " + order;
    }
}
