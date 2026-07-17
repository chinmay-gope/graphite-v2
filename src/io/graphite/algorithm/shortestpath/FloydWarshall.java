package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.exception.algorithm.NegativeCycleException;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.result.AllPairsShortestPathResult;

import java.util.Arrays;

public class FloydWarshall extends GraphAlgorithm implements AllPairsShortestPathAlgorithm {

    public static final int INF = Integer.MAX_VALUE;

    @Override
    public AllPairsShortestPathResult shortestPaths(IGraph graph) {
        validate(graph);
        int vertices = graph.getVertices();

        int[][] distance = createDistanceMatrix(graph);

        for (int via = 0; via < vertices; via++) {
            for (int from = 0; from < vertices; from++) {
                for (int to = 0; to < vertices; to++) {

                    if (distance[from][via] == INF || distance[via][to] == INF) {
                        continue;
                    }

                    if (distance[from][via] + distance[via][to] < distance[from][to]) {
                        distance[from][to] = distance[from][via] + distance[via][to];
                    }
                }
            }
        }

        detectNegativeCycle(distance);
        return new AllPairsShortestPathResult(distance);
    }

    private void detectNegativeCycle(int[][] distance) {

        for (int i = 0; i < distance.length; i++) {
            if (distance[i][i] < 0) {
                throw new NegativeCycleException();
            }
        }
    }

    private int[][] createDistanceMatrix(IGraph graph) {
        int V = graph.getVertices();
        int[][] distance = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;

            for (Edge edge : neighbours(graph, i)) {
                distance[i][edge.destination()] = edge.weight();
            }
        }
        return distance;
    }
}
