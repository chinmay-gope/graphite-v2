package io.graphite.algorithm.topology;

import io.graphite.graph.IGraph;
import io.graphite.result.TopologicalSortResult;

public interface TopologicalAlgorithm {
    TopologicalSortResult sort(IGraph graph);
}
