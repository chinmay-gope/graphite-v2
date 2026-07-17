package io.graphite.algorithm.euler;

import io.graphite.graph.IGraph;
import io.graphite.result.EulerResult;

public interface EulerAlgorithm {
    EulerResult findEulerPath(IGraph graph);

    EulerResult findEulerCircuit(IGraph graph);
}
