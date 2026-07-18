package io.graphite.api;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.graph.IGraph;
import io.graphite.result.MSTResult;

public final class MSTService {
    private final IGraph graph;

    public MSTService(IGraph graph) {
        this.graph = graph;
    }

    public MSTResult prim(int source) {
        return new Prim().findMST(graph, source);
    }

    public MSTResult kruskal() {
        return new Kruskal().findMST(graph);
    }
}
