package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.BiConnectedResult;

public interface BiconnectedAlgorithm {
    BiConnectedResult findBiconnectedComponents(IGraph graph);
}
