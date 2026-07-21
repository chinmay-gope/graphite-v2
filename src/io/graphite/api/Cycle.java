package io.graphite.api;

import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.algorithm.cycle.UndirectedCycleDetector;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;

public final class Cycle extends GraphAPI {
    public Cycle(IGraph graph) {
        super(graph);
    }

    public boolean directed() {
        return DirectedCycleDetector.INSTANCE.hasCycle(graph);
    }

    public boolean undirected() {
        return UndirectedCycleDetector.INSTANCE.hasCycle(graph);
    }
}
