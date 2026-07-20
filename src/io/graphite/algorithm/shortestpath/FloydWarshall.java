package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.exception.algorithm.NegativeCycleException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.AllPairsShortestPathResult;
import io.graphite.validation.GraphPreconditions;

import java.util.Arrays;

public class FloydWarshall extends GraphAlgorithm implements AllPairsShortestPathAlgorithm {

    private FloydWarshall() {
    }

    public static final FloydWarshall INSTANCE = new FloydWarshall();

    public static final int INF = Integer.MAX_VALUE;

    @Override
    public AllPairsShortestPathResult shortestPaths(IGraph graph) {
        GraphPreconditions.requireGraph(graph);
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
