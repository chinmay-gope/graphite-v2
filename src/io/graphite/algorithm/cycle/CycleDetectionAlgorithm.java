package io.graphite.algorithm.cycle;

import io.graphite.graph.IGraph;

public interface CycleDetectionAlgorithm {
    boolean hasCycle(IGraph graph);
}
