package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.APResult;

public interface APAlgorithm {
    APResult findArticulationPoints(IGraph graph);
}
