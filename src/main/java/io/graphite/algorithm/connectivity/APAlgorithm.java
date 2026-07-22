package main.java.io.graphite.algorithm.connectivity;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.APResult;

public interface APAlgorithm {
    APResult findArticulationPoints(IGraph graph);
}
