package io.graphite.api;

import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.algorithm.cycle.UndirectedCycleDetector;
import io.graphite.graph.IGraph;

public final class CycleService extends GraphService {
    public CycleService(IGraph graph) {
        super(graph);
    }

    boolean directed() {
        return new DirectedCycleDetector().hasCycle(graph);
    }

    boolean undirected() {
        return new UndirectedCycleDetector().hasCycle(graph);
    }
}
