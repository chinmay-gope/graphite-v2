package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.BridgeResult;

public interface BridgeAlgorithm {
    BridgeResult findBridges(IGraph graph);
}
