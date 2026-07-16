package io.graphite.algorithm.cycle;

import io.graphite.algorithm.graph.IGraph;

public interface CycleDetectionAlgorithm {
    boolean hasCycle(IGraph graph);
}
