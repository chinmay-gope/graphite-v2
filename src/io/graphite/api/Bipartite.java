package io.graphite.api;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;

public final class Bipartite extends GraphAPI {
    public Bipartite(IGraph graph) {
        super(graph);
    }

    public boolean bfs() {
        return BFSBipartiteChecker.INSTANCE.isBipartite(graph);
    }

    public boolean dfs() {
        return DFSBipartiteChecker.INSTANCE.isBipartite(graph);
    }
}
