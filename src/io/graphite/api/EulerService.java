package io.graphite.api;

import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.graph.IGraph;
import io.graphite.result.EulerResult;

public final class EulerService extends GraphService {

    public EulerService(IGraph graph) {
        super(graph);
    }

    public EulerResult path() {
        return new Hierholzer().findEulerPath(graph);
    }

    public EulerResult circuit() {
        return new Hierholzer().findEulerCircuit(graph);
    }
}
