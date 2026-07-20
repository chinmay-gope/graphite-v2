package io.graphite.algorithm.connectivity;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.BridgeResult;
import io.graphite.validation.GraphPreconditions;

import java.util.ArrayList;
import java.util.List;

public class BridgeFinder extends GraphAlgorithm implements BridgeAlgorithm {
    private int time;

    private BridgeFinder() {
    }

    public static BridgeFinder INSTANCE = new BridgeFinder();

    @Override
    public BridgeResult findBridges(IGraph graph) {
        GraphPreconditions.requireGraph(graph);
        GraphPreconditions.requireUndirected(graph);

        boolean[] visited = booleans(graph);

        int[] discovery = ints(graph, 0);
        int[] low = ints(graph, 0);

        List<Edge> bridges = new ArrayList<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(
                        graph,
                        i,
                        -1,
                        visited,
                        discovery,
                        low,
                        bridges
                );
            }
        }
        return new BridgeResult(bridges);
    }

    private void dfs(
            IGraph graph,
            int current,
            int parent,
            boolean[] visited,
            int[] discovery,
            int[] low,
            List<Edge> bridges) {
        visited[current] = true;
        discovery[current] = low[current] = time++;

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();

            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {
                dfs(
                        graph,
                        neighbour,
                        current,
                        visited,
                        discovery,
                        low,
                        bridges
                );

                // Update the lowest discovery time reachable.
                low[current] = Math.min(low[current], low[neighbour]);

                // If the neighbor cannot reach an ancestor of current,
                // then current -> neighbor is a bridge.
                if (low[neighbour] > discovery[current]) {
                    bridges.add(new Edge(
                            current,
                            neighbour,
                            edge.weight()
                    ));
                }

            } else {
                // Back edge found.
                low[current] = Math.min(low[current], discovery[neighbour]);
            }
        }
    }
}
