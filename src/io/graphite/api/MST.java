package io.graphite.api;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.MSTResult;

public final class MST extends GraphAPI {
    public MST(IGraph graph) {
        super(graph);
    }

    public MSTResult prim(int source) {
        return  Prim.INSTANCE.findMST(graph, source);
    }

    public MSTResult kruskal() {
        return  Kruskal.INSTANCE.findMST(graph);
    }
}
