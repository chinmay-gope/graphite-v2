package io.graphite.generator.pattern;

import io.graphite.builder.Graphs;
import io.graphite.exception.graph.InvalidGraphConfigurationException;
import io.graphite.graph.IGraph;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class DAGGenerator {

    private DAGGenerator() {
    }

    public static IGraph generate(
            int vertices,
            int edges) {

        // validation
        if (vertices <= 0) {
            throw new InvalidGraphConfigurationException(
                    "DAG requires at least one vertex.");
        }

        if (edges < 0) {
            throw new InvalidGraphConfigurationException(
                    "Edge count cannot be negative.");
        }

        int maxEdges = vertices * (vertices - 1) / 2;

        if (edges > maxEdges) {
            throw new InvalidGraphConfigurationException(
                    "A DAG with " + vertices + " vertices can contain at most "
                            + maxEdges + " edges.");
        }

        var builder = Graphs.directed()
                .vertices(vertices);

        ThreadLocalRandom random =
                ThreadLocalRandom.current();

        Set<EdgeKey> used =
                new HashSet<>();

        while (used.size() < edges) {

            int source =
                    random.nextInt(vertices - 1);

            int destination =
                    random.nextInt(source + 1, vertices);

            if (used.add(new EdgeKey(source, destination))) {
                builder.addEdge(source, destination);
            }
        }

        return builder.build();
    }

    private record EdgeKey(
            int source,
            int destination) {
    }
}
