package io.graphite.model;

/**
 * Represents a vertex together with its associated cost.
 *
 * <p>This record is primarily used by priority queue based graph
 * algorithms such as Dijkstra's and Prim's algorithms.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see io.graphite.algorithm.shortestpath.Dijkstra
 * @see io.graphite.algorithm.mst.Prim
 * @since 2.0
 */
public record VertexCost(int vertex, int cost)
        implements Comparable<VertexCost> {

    @Override
    public int compareTo(VertexCost other) {
        return Integer.compare(cost, other.cost);
    }
}
