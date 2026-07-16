package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.AllPairsShortestPathResult;

public interface AllPairsShortestPathAlgorithm {
    AllPairsShortestPathResult shortestPaths(IGraph graph);
}
