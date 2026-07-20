package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.APResult;
import io.graphite.validation.GraphPreconditions;

import java.util.ArrayList;
import java.util.List;

public class APFinder extends GraphAlgorithm implements APAlgorithm {

    private APFinder() {
    }

    public static final APFinder INSTANCE = new APFinder();

    private int time;

    @Override
    public APResult findArticulationPoints(IGraph graph) {
        GraphPreconditions.requireGraph(graph);
        GraphPreconditions.requireUndirected(graph);

        boolean[] visited = booleans(graph);

        int[] discovery = ints(graph, 0);
        int[] low = ints(graph, 0);

        boolean[] articulation = booleans(graph);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(
                        graph,
                        i,
                        -1,
                        visited,
                        discovery,
                        low,
                        articulation
                );
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < articulation.length; i++) {
            if (articulation[i]) {
                result.add(i);
            }
        }
        return new APResult(result);
    }

    private void dfs(
            IGraph graph,
            int current,
            int parent,
            boolean[] visited,
            int[] discovery,
            int[] low,
            boolean[] articulation) {

        visited[current] = true;
        discovery[current] = low[current] = ++time;

        int children = 0;

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();

            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {
                children++;

                dfs(
                        graph,
                        neighbour,
                        current,
                        visited,
                        discovery,
                        low,
                        articulation
                );

                low[current] = Math.min(low[current], low[neighbour]);

                if (parent == -1 && children > 1) {
                    articulation[current] = true;
                }

                if (parent != -1 && low[neighbour] >= discovery[current]) {
                    articulation[current] = true;
                }

            } else {
                low[current] = Math.min(
                        low[current],
                        discovery[neighbour]
                );
            }
        }
    }
}
