package io.graphite.algorithm.connectivity;

import io.graphite.graph.IGraph;
import io.graphite.result.BridgeResult;

public interface BridgeAlgorithm {
    BridgeResult findBridges(IGraph graph);
}
