package io.graphite.algorithm.shortestpath;


import io.graphite.graph.IGraph;
import io.graphite.result.AllPairsShortestPathResult;

public interface AllPairsShortestPathAlgorithm {
    AllPairsShortestPathResult shortestPaths(IGraph graph);
}
