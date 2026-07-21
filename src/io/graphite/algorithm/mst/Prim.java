package io.graphite.algorithm.mst;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.exception.graph.GraphDisconnectedException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.model.MSTNode;
import io.graphite.result.MSTEdge;
import io.graphite.result.MSTResult;
import io.graphite.validation.GraphPreconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim extends GraphAlgorithm {
    private Prim() {
    }

    public static final Prim INSTANCE = new Prim();

    public MSTResult findMST(IGraph graph, int source) {
        GraphPreconditions.requireGraph(graph);
        GraphPreconditions.requireUndirected(graph);

        boolean[] visited = booleans(graph);

        PriorityQueue<MSTNode> queue = new PriorityQueue<>();

        List<MSTEdge> mst = new ArrayList<>();

        int cost = 0;
        queue.offer(new MSTNode(-1, source, 0));

        while (!queue.isEmpty()) {
            MSTNode current = queue.poll();

            int parent = current.parent();
            int vertex = current.vertex();
            int weight = current.weight();

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;

            if (parent != -1) {
                mst.add(new MSTEdge(parent, vertex, weight));
                cost += weight;
            }

            for (Edge edge : neighbours(graph, vertex)) {
                if (!visited[edge.destination()]) {

                    queue.offer(new MSTNode(vertex, edge.destination(), edge.weight()));
                }
            }
        }

        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                throw new GraphDisconnectedException("Minimum spanning tree requires a connected graph.");
            }
        }

        return new MSTResult(cost, mst);
    }
}
