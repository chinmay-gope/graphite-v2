package main.java.io.graphite.algorithm.shortestpath;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.ShortestPathResult;

public interface ShortestPathAlgorithm {
    ShortestPathResult shortestPath(IGraph graph, int source);
}
