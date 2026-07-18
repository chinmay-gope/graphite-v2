package io.graphite.api;

import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.graph.IGraph;
import io.graphite.result.EulerResult;

public final class EulerService extends GraphService {

    EulerService(IGraph graph) {
        super(graph);
    }

    public EulerResult findEulerPath() {
        return new Hierholzer().findEulerPath(graph);
    }

    public EulerResult findEulerCircuit() {
        return new Hierholzer().findEulerCircuit(graph);
    }
}
