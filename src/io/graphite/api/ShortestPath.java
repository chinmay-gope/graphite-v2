package io.graphite.api;

import io.graphite.algorithm.shortestpath.BellmanFord;
import io.graphite.algorithm.shortestpath.Dijkstra;
import io.graphite.algorithm.shortestpath.FloydWarshall;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.AllPairsShortestPathResult;
import io.graphite.result.ShortestPathResult;

public final class ShortestPath extends GraphAPI {
    public ShortestPath(IGraph graph) {
        super(graph);
    }

    public ShortestPathResult dijkstra(int source) {
        return Dijkstra.INSTANCE.shortestPath(graph, source);
    }

    public ShortestPathResult bellmanFord(int source) {
        return BellmanFord.INSTANCE.shortestPath(graph, source);
    }

    public AllPairsShortestPathResult floydWarshall() {
        return FloydWarshall.INSTANCE.shortestPaths(graph);
    }
}
