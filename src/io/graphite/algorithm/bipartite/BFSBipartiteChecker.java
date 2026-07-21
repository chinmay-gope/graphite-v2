package io.graphite.algorithm.bipartite;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.validation.GraphPreconditions;
import io.graphite.validation.GraphValidator;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSBipartiteChecker extends GraphAlgorithm implements BipartiteAlgorithm {

    private BFSBipartiteChecker() {

    }

    public static final BFSBipartiteChecker INSTANCE = new BFSBipartiteChecker();

    @Override
    public boolean isBipartite(IGraph graph) {
        GraphPreconditions.requireGraph(graph);
        GraphPreconditions.requireUndirected(graph);

        if (GraphValidator.hasSelfLoop(graph)) {
            return false;
        }

        int[] color = ints(graph, -1);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(IGraph graph, int source, int[] color) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        color[source] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Edge edge : neighbours(graph, current)) {
                int neighbour = edge.destination();

                // Not booleans yet
                if (color[neighbour] == -1) {
                    // Assign opposite color
                    color[neighbour] = 1 - color[current];
                    queue.offer(neighbour);
                }

                // Already booleans and same color
                else if (color[neighbour] == color[current]) {
                    return false;
                }

            }
        }

        return true;
    }
}
