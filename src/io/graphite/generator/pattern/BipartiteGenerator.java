package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class BipartiteGenerator {

    private BipartiteGenerator() {
    }

    private int left;
    private int right;
    private int edges;

    public BipartiteGenerator left(int left) {
        this.left = left;
        return this;
    }

    public BipartiteGenerator right(int right) {
        this.right = right;
        return this;
    }

    public BipartiteGenerator edges(int edges) {
        this.edges = edges;
        return this;
    }

    public IGraph generate() {

        var builder =
                Graphs.undirected()
                        .vertices(left + right);

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Set<String> used =
                new HashSet<>();

        while (used.size() < edges) {

            int u = random.nextInt(left);

            int v = random.nextInt(left, left + right);

            String key = u + "-" + v;

            if (used.add(key))
                builder.addEdge(u, v);
        }

        return builder.build();
    }
}
