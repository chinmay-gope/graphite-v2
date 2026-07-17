package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.exception.algorithm.NegativeCycleException;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.result.ShortestPathResult;

import java.util.List;

public class BellmanFord extends GraphAlgorithm implements ShortestPathAlgorithm {
    @Override
    public ShortestPathResult shortestPath(IGraph graph, int source) {
        validate(graph);
        validateVertex(graph, source);

        int[] distance = ints(graph, Integer.MAX_VALUE);

        distance[source] = 0;

        List<Edge> edges = graph.getEdges();

        relaxEdges(edges, distance, graph.getVertices());

        detectNegativeCycle(edges, distance);

        return new ShortestPathResult(source, distance);
    }

    private void relaxEdges(List<Edge> edges,
                            int[] distance,
                            int vertices) {

        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {

                int u = edge.source();
                int v = edge.destination();
                int wt = edge.weight();

                if (distance[u] != Integer.MAX_VALUE &&
                        distance[u] + wt < distance[v]) {

                    distance[v] = distance[u] + wt;
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
