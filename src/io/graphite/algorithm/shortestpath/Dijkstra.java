package io.graphite.algorithm.shortestpath;

import io.graphite.algorithm.GraphAlgorithm;
import io.graphite.exception.algorithm.NegativeWeightException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.model.VertexCost;
import io.graphite.result.ShortestPathResult;
import io.graphite.validation.GraphValidator;

import java.util.PriorityQueue;

public class Dijkstra extends GraphAlgorithm implements ShortestPathAlgorithm {

    private Dijkstra() {
    }

    public static final Dijkstra INSTANCE = new Dijkstra();

    @Override
    public ShortestPathResult shortestPath(IGraph graph, int source) {
        validate(graph);
        validateVertex(graph, source);

        if (GraphValidator.hasNegativeEdges(graph)) {
            throw new NegativeWeightException("Dijkstra cannot be applied to graphs with negative edge weights.");
        }

        int[] distance = ints(graph, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<VertexCost> queue = new PriorityQueue<>();

        queue.offer(new VertexCost(source, 0));

        while (!queue.isEmpty()) {
            VertexCost current = queue.poll();

            int u = current.vertex();

            /*
             *   Java's PriorityQueue doesn't support decrease-key.
             *   Instead of updating an existing entry, a new one is added.
             *   Ignore stale entries whose cost is no longer optimal.
             */
            if (current.cost() > distance[u]) {
                continue;
            }

            for (Edge edge : neighbours(graph, u)) {
                int v = edge.destination();
                int wt = edge.weight();

                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;

                    queue.offer(new VertexCost(v, distance[v]));
                }
            }
        }

        return new ShortestPathResult(source, distance);
    }
}
