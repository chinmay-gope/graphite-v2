package io.graphite.algorithm.connectivity;

import io.graphite.graph.IGraph;
import io.graphite.result.SCCResult;

public interface SCCAlgorithm {
    SCCResult findSCCs(IGraph graph);
}
