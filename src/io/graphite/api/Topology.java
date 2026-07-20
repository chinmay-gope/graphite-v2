package io.graphite.api;

import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.TopologicalSortResult;

public final class Topology extends GraphAPI {
    public Topology(IGraph graph) {
        super(graph);
    }

    public TopologicalSortResult dfs() {
        return DFSTopologicalSort.INSTANCE.sort(graph);
    }

    public TopologicalSortResult kahn() {
        return KahnTopologicalSort.INSTANCE.sort(graph);
    }
}
