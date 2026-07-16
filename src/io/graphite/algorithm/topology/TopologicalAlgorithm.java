package io.graphite.algorithm.topology;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.TopologicalSortResult;

public interface TopologicalAlgorithm {
    TopologicalSortResult sort(IGraph graph);
}
