package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.SCCResult;

public interface SCCAlgorithm {
    SCCResult findSCCs(IGraph graph);
}
