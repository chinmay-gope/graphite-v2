package main.java.io.graphite.algorithm.euler;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.EulerResult;

public interface EulerAlgorithm {
    EulerResult findEulerPath(IGraph graph);

    EulerResult findEulerCircuit(IGraph graph);
}
