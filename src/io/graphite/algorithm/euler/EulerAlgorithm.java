package io.graphite.algorithm.euler;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.EulerResult;

public interface EulerAlgorithm {
    EulerResult findEulerPath(IGraph graph);

    EulerResult findEulerCircuit(IGraph graph);
}
