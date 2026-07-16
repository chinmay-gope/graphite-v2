package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.model.GraphEdge;
import io.graphite.algorithm.result.BiConnectedResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BiconnectedComponents extends GraphAlgorithm
        implements BiconnectedAlgorithm {

    @Override
    public BiConnectedResult findBiconnectedComponents(IGraph graph) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        int n = graph.getVertices();

        boolean[] visited = new boolean[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];

        Arrays.fill(parent, -1);

        Stack<GraphEdge> stack = new Stack<>();
        List<List<GraphEdge>> result = new ArrayList<>();

        int time = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                time = dfs(
                        graph,
                        i,
                        visited,
                        disc,
                        low,
                        parent,
                        stack,
                        result,
                        time
                );

                // Remaining edges belong to one BCC
                if (!stack.isEmpty()) {
                    List<GraphEdge> component = new ArrayList<>();

                    while (!stack.isEmpty()) {
                        component.add(stack.pop());
                    }

                    result.add(component);
                }
            }
        }

        return new BiConnectedResult(result, result.size());
    }

    private int dfs(
            IGraph graph,
            int u,
            boolean[] visited,
            int[] disc,
            int[] low,
            int[] parent,
            Stack<GraphEdge> stack,
            List<List<GraphEdge>> result,
            int time
    ) {

        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Edge edge : graph.getAdjacencyList().get(u)) {

            int v = edge.destination();

            GraphEdge graphEdge = new GraphEdge(
                    u,
                    v,
                    edge.weight()
            );

            if (!visited[v]) {
                parent[v] = u;
                stack.push(graphEdge);

                time = dfs(
                        graph,
                        v,
                        visited,
                        disc,
                        low,
                        parent,
                        stack,
                        result,
                        time
                );

                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= disc[u]) {
                    List<GraphEdge> component = new ArrayList<>();

                    while (!stack.isEmpty()) {
                        GraphEdge e = stack.pop();
                        component.add(e);

                        if ((e.source() == u && e.destination() == v)
                                || (e.source() == v && e.destination() == u)) {
                            break;
                        }
                    }

                    result.add(component);
                }

            } else if (v != parent[u] && disc[v] < disc[u]) {
                stack.push(graphEdge);

                low[u] = Math.min(low[u], disc[v]);
            }
        }

        return time;
    }
}
