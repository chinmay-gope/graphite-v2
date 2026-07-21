package io.graphite.algorithm.bipartite;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.validation.GraphPreconditions;
import io.graphite.validation.GraphValidator;

public class DFSBipartiteChecker
        extends GraphAlgorithm
        implements BipartiteAlgorithm {

    private DFSBipartiteChecker() {
    }

    public static final DFSBipartiteChecker INSTANCE = new DFSBipartiteChecker();

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
                if (dfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(
            IGraph graph,
            int current,
            int[] color) {

        for (Edge edge : neighbours(graph, current)) {

            int neighbour = edge.destination();

            if (color[neighbour] == -1) {

                color[neighbour] = 1 - color[current];

                if (dfs(graph, neighbour, color)) {
                    return true;
                }
            } else if (color[neighbour] == color[current]) {
                return true;
            }
        }

        return false;
    }
}
