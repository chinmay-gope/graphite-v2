package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.result.SCCResult;
import io.graphite.algorithm.util.GraphUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Kosaraju extends GraphAlgorithm implements SCCAlgorithm {
    @Override
    public SCCResult findSCCs(IGraph graph) {
        validate(graph);
        requireDirectedGraph(graph);

        boolean[] visited = booleans(graph);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                fillOrder(graph, i, visited, stack);
            }
        }

        IGraph transpose = GraphUtils.transpose(graph);

        visited = booleans(graph);

        List<List<Integer>> components = new ArrayList<>();

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                List<Integer> component = new ArrayList<>();
                dfs(transpose, vertex, visited, component);
                components.add(component);
            }
        }

        return new SCCResult(components);
    }

    private void fillOrder(
            IGraph graph,
            int current,
            boolean[] visited,
            Deque<Integer> stack) {

        visited[current] = true;

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();

            if (!visited[neighbour]) {
                fillOrder(graph, neighbour, visited, stack);
            }
        }
        stack.push(current);
    }

    private void dfs(
            IGraph graph,
            int current,
            boolean[] visited,
            List<Integer> component) {
        visited[current] = true;
        component.add(current);

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();
            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited, component);
            }
        }
    }
}
