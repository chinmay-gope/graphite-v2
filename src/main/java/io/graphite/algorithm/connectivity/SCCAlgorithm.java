package main.java.io.graphite.algorithm.connectivity;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.SCCResult;

public interface SCCAlgorithm {
    SCCResult findSCCs(IGraph graph);
}
