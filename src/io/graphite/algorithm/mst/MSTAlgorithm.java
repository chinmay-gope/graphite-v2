package io.graphite.algorithm.mst;

import io.graphite.graph.IGraph;
import io.graphite.result.MSTResult;

public interface MSTAlgorithm {
    MSTResult findMST(IGraph graph, int source);
}
