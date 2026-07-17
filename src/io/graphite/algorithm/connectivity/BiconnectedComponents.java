package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.BiConnectedResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BiconnectedComponents extends GraphAlgorithm
        implements BiconnectedAlgorithm {

    @Override
    public BiConnectedResult findBiconnectedComponents(IGraph graph) {
        validate(graph);
        requireUndirected(graph);

        boolean[] visited = booleans(graph);
        int[] disc = ints(graph, 0);
        int[] low = ints(graph, 0);
        int[] parent = ints(graph, -1);

        Stack<Edge> stack = new Stack<>();
        List<List<Edge>> result = new ArrayList<>();

        int time = 0;

        for (int i = 0; i < graph.getVertices(); i++) {

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
                    List<Edge> component = new ArrayList<>();

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
            Stack<Edge> stack,
            List<List<Edge>> result,
            int time
    ) {

        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Edge edge : graph.getAdjacencyList().get(u)) {

            int v = edge.destination();

            Edge graphEdge = new Edge(
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
                    List<Edge> component = new ArrayList<>();

                    while (!stack.isEmpty()) {
                        Edge e = stack.pop();
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
