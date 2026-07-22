package main.java.io.graphite.algorithm.connectivity;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.BridgeResult;

public interface BridgeAlgorithm {
    BridgeResult findBridges(IGraph graph);
}
