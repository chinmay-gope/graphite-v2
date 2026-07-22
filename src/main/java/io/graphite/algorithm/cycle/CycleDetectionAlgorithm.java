package main.java.io.graphite.algorithm.cycle;

import main.java.io.graphite.graph.IGraph;

public interface CycleDetectionAlgorithm {
    boolean hasCycle(IGraph graph);
}
