package io.graphite.algorithm.connectivity;

import io.graphite.graph.IGraph;
import io.graphite.result.BiConnectedResult;

public interface BiconnectedAlgorithm {
    BiConnectedResult findBiconnectedComponents(IGraph graph);
}
