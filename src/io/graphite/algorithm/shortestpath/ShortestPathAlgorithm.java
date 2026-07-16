package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.ShortestPathResult;

public interface ShortestPathAlgorithm {
    ShortestPathResult shortestPath(IGraph graph, int source);
}
