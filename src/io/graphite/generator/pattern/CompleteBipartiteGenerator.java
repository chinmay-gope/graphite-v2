package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

public final class CompleteBipartiteGenerator {

    private CompleteBipartiteGenerator() {
    }

    private int left;
    private int right;

    public CompleteBipartiteGenerator left(int left) {
        this.left = left;
        return this;
    }

    public CompleteBipartiteGenerator right(int right) {
        this.right = right;
        return this;
    }

    public IGraph generate() {

        var builder =
                Graphs.undirected()
                        .vertices(left + right);

        for (int u = 0; u < left; u++) {

            for (int v = left; v < left + right; v++) {

                builder.addEdge(u, v);
            }
        }

        return builder.build();
    }
}
