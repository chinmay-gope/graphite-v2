package main.java.io.graphite.generator.internal;

import main.java.io.graphite.builder.GraphConfiguration;

import java.util.HashSet;
import java.util.Set;

public final class EdgeTracker {
    private final GraphConfiguration configuration;
    private final Set<EdgeKey> edges = new HashSet<>();

    public EdgeTracker(GraphConfiguration configuration) {
        this.configuration = configuration;
    }

    public void remember(int source, int destination) {
        edges.add(key(source, destination));
    }

    public boolean contains(int source, int destination) {
        return edges.contains(key(source, destination));
    }

    public int size() {
        return edges.size();
    }

    private EdgeKey key(int source, int destination) {

        if (configuration.isUndirected()) {
            return new EdgeKey(
                    Math.min(source, destination),
                    Math.max(source, destination));
        }

        return new EdgeKey(source, destination);
    }
}
