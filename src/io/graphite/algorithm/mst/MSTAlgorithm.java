package io.graphite.algorithm.mst;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.MSTResult;

public interface MSTAlgorithm {
    MSTResult findMST(IGraph graph, int source);
}
