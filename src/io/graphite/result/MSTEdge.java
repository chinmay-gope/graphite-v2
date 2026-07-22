package io.graphite.result;

/**
 * Represents an edge contained in a Minimum Spanning Tree.
 *
 * <p>An {@code MSTEdge} records the source vertex, destination vertex,
 * and weight of an edge selected by an MST algorithm.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see MSTResult
 * @see io.graphite.algorithm.mst.Prim
 * @see io.graphite.algorithm.mst.Kruskal
 * @since 2.0
 */
public record MSTEdge(
        int source,
        int destination,
        int weight
) {

    @Override
    public String toString() {
        return String.format("%d ──(%d)──> %d", source, weight, destination);
    }
}
