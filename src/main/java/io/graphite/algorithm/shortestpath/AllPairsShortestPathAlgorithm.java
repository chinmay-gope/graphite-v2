package main.java.io.graphite.algorithm.shortestpath;


import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.AllPairsShortestPathResult;

public interface AllPairsShortestPathAlgorithm {
    AllPairsShortestPathResult shortestPaths(IGraph graph);
}
