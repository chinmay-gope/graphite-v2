package io.graphite.api;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.graph.IGraph;

public final class BipartiteService extends GraphService {
    public BipartiteService(IGraph graph) {
        super(graph);
    }

    boolean bfs() {
        return new BFSBipartiteChecker().isBipartite(graph);
    }

    boolean dfs() {
        return new DFSBipartiteChecker().isBipartite(graph);
    }
}
