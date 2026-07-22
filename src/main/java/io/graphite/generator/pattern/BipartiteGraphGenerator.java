package main.java.io.graphite.generator.pattern;

import main.java.io.graphite.builder.Graphs;
import main.java.io.graphite.exception.graph.InvalidGraphConfigurationException;
import main.java.io.graphite.graph.IGraph;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class BipartiteGraphGenerator {

    private BipartiteGraphGenerator() {
    }

    public static IGraph generate(int left, int right) {
        return generate(left, right, left + right);
    }

    public static IGraph generate(int left, int right, int edges) {

        if (left <= 0) {
            throw new InvalidGraphConfigurationException(
                    "Left partition must contain at least one vertex.");
        }

        if (right <= 0) {
            throw new InvalidGraphConfigurationException(
                    "Right partition must contain at least one vertex.");
        }

        if (edges < 0) {
            throw new InvalidGraphConfigurationException(
                    "Edge count cannot be negative.");
        }

        int maxEdges = left * right;

        if (edges > maxEdges) {
            throw new InvalidGraphConfigurationException(
                    "A bipartite graph with partitions of size "
                            + left + " and " + right
                            + " can contain at most "
                            + maxEdges + " edges.");
        }

        var builder = Graphs.undirected()
                .vertices(left + right);

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Set<EdgeKey> used = new HashSet<>();

        while (used.size() < edges) {

            int u = random.nextInt(left);
            int v = random.nextInt(left, left + right);

            if (used.add(new EdgeKey(u, v))) {
                builder.addEdge(u, v);
            }
        }

        return builder.build();
    }

    private record EdgeKey(int source, int destination) {
    }
}
