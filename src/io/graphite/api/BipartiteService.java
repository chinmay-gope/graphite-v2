package io.graphite.api;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.graph.IGraph;

public final class BipartiteService extends GraphService {
    public BipartiteService(IGraph graph) {
        super(graph);
    }

    public boolean bfs() {
        return new BFSBipartiteChecker().isBipartite(graph);
    }

    public boolean dfs() {
        return new DFSBipartiteChecker().isBipartite(graph);
    }
}
