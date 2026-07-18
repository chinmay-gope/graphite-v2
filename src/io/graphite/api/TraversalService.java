package io.graphite.api;

import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.graph.IGraph;
import io.graphite.result.TraversalResult;

public final class TraversalService extends GraphService {

    public TraversalService(IGraph graph) {
        super(graph);
    }

    public TraversalResult bfs(int source) {
        return new BFS().traverse(graph, source);
    }

    public TraversalResult dfs(int source) {
        return new DFS().traverse(graph, source);
    }
}
