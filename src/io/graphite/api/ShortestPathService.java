package io.graphite.api;

import io.graphite.algorithm.shortestpath.BellmanFord;
import io.graphite.algorithm.shortestpath.Dijkstra;
import io.graphite.algorithm.shortestpath.FloydWarshall;
import io.graphite.graph.IGraph;
import io.graphite.result.AllPairsShortestPathResult;
import io.graphite.result.ShortestPathResult;

public final class ShortestPathService extends GraphService {
    ShortestPathService(IGraph graph) {
        super(graph);
    }

    ShortestPathResult dijkstra(int source) {
        return new Dijkstra().shortestPath(graph, source);
    }

    ShortestPathResult bellmanFord(int source) {
        return new BellmanFord().shortestPath(graph, source);
    }

    AllPairsShortestPathResult floydWarshall() {
        return new FloydWarshall().shortestPaths(graph);
    }
}
