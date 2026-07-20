package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.exception.algorithm.NegativeCycleException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.ShortestPathResult;
import io.graphite.validation.GraphPreconditions;

import java.util.List;

public class BellmanFord extends GraphAlgorithm implements ShortestPathAlgorithm {

    private BellmanFord() {
    }

    public static final BellmanFord INSTANCE = new BellmanFord();

    @Override
    public ShortestPathResult shortestPath(IGraph graph, int source) {
        GraphPreconditions.requireGraph(graph);
        GraphPreconditions.requireVertex(graph, source);

        int[] distance = ints(graph, Integer.MAX_VALUE);
        int[] parent = ints(graph, -1);

        distance[source] = 0;

        List<Edge> edges = edges(graph);

        relaxEdges(edges, distance, parent, graph.getVertices());

        detectNegativeCycle(edges, distance);

        return new ShortestPathResult(source, distance, parent);
    }

    private void relaxEdges(List<Edge> edges,
                            int[] distance,
                            int[] parent,
                            int vertices) {

        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {

                int u = edge.source();
                int v = edge.destination();
                int wt = edge.weight();

                if (distance[u] != Integer.MAX_VALUE &&
                        distance[u] + wt < distance[v]) {

                    distance[v] = distance[u] + wt;
                    parent[v] = u;
                }
            }
        }
    }

    private void detectNegativeCycle(List<Edge> edges, int[] distance) {
        for (Edge edge : edges) {
            int u = edge.source();
            int v = edge.destination();
            int wt = edge.weight();

            if (distance[u] + wt < distance[v] && distance[u] != Integer.MAX_VALUE) {

                throw new NegativeCycleException();
            }
        }
    }
}
