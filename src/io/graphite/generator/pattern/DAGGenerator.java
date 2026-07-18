package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class DAGGenerator {

    private DAGGenerator() {
    }

    private int vertices;
    private int edges;

    public DAGGenerator vertices(int vertices) {
        this.vertices = vertices;
        return this;
    }

    public DAGGenerator edges(int edges) {
        this.edges = edges;
        return this;
    }

    public IGraph generate() {

        var builder =
                Graphs.directed()
                        .vertices(vertices);

        ThreadLocalRandom random =
                ThreadLocalRandom.current();

        Set<String> used =
                new HashSet<>();

        while (used.size() < edges) {

            int source =
                    random.nextInt(vertices - 1);

            int destination =
                    random.nextInt(source + 1, vertices);

            String key =
                    source + "-" + destination;

            if (used.add(key))
                builder.addEdge(source, destination);
        }

        return builder.build();
    }
}
