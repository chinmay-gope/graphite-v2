package io.graphite.algorithm.mst;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.exception.graph.GraphDisconnectedException;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.model.MSTNode;
import io.graphite.algorithm.result.MSTEdge;
import io.graphite.algorithm.result.MSTResult;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim extends GraphAlgorithm implements MSTAlgorithm {
    @Override
    public MSTResult findMST(IGraph graph, int source) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        boolean[] visited = createVisitedArray(graph);

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

                    queue.offer(new MSTNode(
                            vertex,
                            edge.destination(),
                            edge.weight()
                    ));
                }
            }
        }

        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                throw new GraphDisconnectedException(
                        "Minimum spanning tree requires a connected graph.");
            }
        }

        return new MSTResult(cost, mst);
    }
}
