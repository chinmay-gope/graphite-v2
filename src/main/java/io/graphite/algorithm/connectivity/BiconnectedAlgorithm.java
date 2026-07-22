package main.java.io.graphite.algorithm.connectivity;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.BiConnectedResult;

public interface BiconnectedAlgorithm {
    BiConnectedResult findBiconnectedComponents(IGraph graph);
}
