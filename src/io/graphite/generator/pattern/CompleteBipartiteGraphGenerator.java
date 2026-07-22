package io.graphite.generator.pattern;

import io.graphite.graph.IGraph;

/**
 * Generates complete bipartite graphs.
 *
 * <p>A complete bipartite graph partitions vertices into two disjoint sets
 * where every vertex in one partition is connected to every vertex in the
 * other partition.</p>
 *
 * @author Chinmay
 * @since 2.0
 * @version 2.0
 *
 * @see io.graphite.graph.PatternGraphFactory
 */
public final class CompleteBipartiteGraphGenerator {

    private CompleteBipartiteGraphGenerator() {
    }

    public static IGraph generate(int left, int right) {
        return BipartiteGraphGenerator.generate(left, right, left * right); // complete-bipartite edge overload
    }
}
