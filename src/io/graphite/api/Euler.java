package io.graphite.api;

import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.EulerResult;

public final class Euler extends GraphAPI {

    public Euler(IGraph graph) {
        super(graph);
    }

    public EulerResult path() {
        return  Hierholzer.INSTANCE.findEulerPath(graph);
    }

    public EulerResult circuit() {
        return  Hierholzer.INSTANCE.findEulerCircuit(graph);
    }
}
