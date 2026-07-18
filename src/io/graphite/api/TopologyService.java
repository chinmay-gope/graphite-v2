package io.graphite.api;

import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.graph.IGraph;
import io.graphite.result.TopologicalSortResult;

public final class TopologyService extends GraphService {
    public TopologyService(IGraph graph) {
        super(graph);
    }

    TopologicalSortResult dfs() {
        return new DFSTopologicalSort().sort(graph);
    }

    TopologicalSortResult kahn(IGraph graph) {
        return new KahnTopologicalSort().sort(graph);
    }
}
