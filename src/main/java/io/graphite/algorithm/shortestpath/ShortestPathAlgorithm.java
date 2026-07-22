package io.graphite.algorithm.shortestpath;

import io.graphite.graph.IGraph;
import io.graphite.result.ShortestPathResult;

public interface ShortestPathAlgorithm {
    ShortestPathResult shortestPath(IGraph graph, int source);
}
