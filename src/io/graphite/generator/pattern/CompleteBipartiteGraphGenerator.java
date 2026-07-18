package io.graphite.generator.pattern;

import io.graphite.graph.IGraph;

public final class CompleteBipartiteGraphGenerator {

    private CompleteBipartiteGraphGenerator() {
    }

    public static IGraph generate(int left, int right) {
        return BipartiteGraphGenerator.generate(left, right, left * right); // complete-bipartite edge overload
    }
}
