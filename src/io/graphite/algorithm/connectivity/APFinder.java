package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.result.APResult;

import java.util.ArrayList;
import java.util.List;

public class APFinder extends GraphAlgorithm implements APAlgorithm {

    private int time;

    @Override
    public APResult findArticulationPoints(IGraph graph) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        boolean[] visited = createVisitedArray(graph);

        int[] discovery = new int[graph.getVertices()];
        int[] low = new int[graph.getVertices()];

        boolean[] articulation = new boolean[graph.getVertices()];

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
