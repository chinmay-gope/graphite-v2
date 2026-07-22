package io.graphite.algorithm.connectivity;

import io.graphite.graph.IGraph;
import io.graphite.result.APResult;

public interface APAlgorithm {
    APResult findArticulationPoints(IGraph graph);
}
