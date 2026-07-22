package main.java.io.graphite.algorithm.topology;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.TopologicalSortResult;

public interface TopologicalAlgorithm {
    TopologicalSortResult sort(IGraph graph);
}
