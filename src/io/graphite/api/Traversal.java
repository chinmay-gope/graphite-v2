package io.graphite.api;

import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.TraversalResult;

public final class Traversal extends GraphAPI {

    public Traversal(IGraph graph) {
        super(graph);
    }

    public TraversalResult bfs(int source) {
        return BFS.INSTANCE.traverse(graph, source);
    }

    public TraversalResult dfs(int source) {
        return DFS.INSTANCE.traverse(graph, source);
    }
}
