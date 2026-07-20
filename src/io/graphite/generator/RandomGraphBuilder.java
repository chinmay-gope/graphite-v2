package io.graphite.generator;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.IGraph;

public final class RandomGraphBuilder {

    public RandomGraphBuilder() {
    }

    private final GraphConfiguration configuration =
            new GraphConfiguration();

    public RandomGraphBuilder directed() {
        configuration.setDirected(true);
        return this;
    }

    public RandomGraphBuilder undirected() {
        configuration.setDirected(false);
        return this;
    }

    public RandomGraphBuilder vertices(int vertices) {
        configuration.setVertices(vertices);
        return this;
    }

    public RandomGraphBuilder edges(int edges) {
        configuration.setEdges(edges);
        return this;
    }

    public RandomGraphBuilder weighted() {
        configuration.setWeighted(true);
        return this;
    }

    public RandomGraphBuilder unweighted() {
        configuration.setWeighted(false);
        return this;
    }

    public RandomGraphBuilder connected() {
        configuration.setConnected(true);
        return this;
    }

    public RandomGraphBuilder disconnected() {
        configuration.setConnected(false);
        return this;
    }

    public RandomGraphBuilder allowSelfLoops() {
        configuration.setSelfLoops(true);
        return this;
    }

    public RandomGraphBuilder allowParallelEdges() {
        configuration.setParallelEdges(true);
        return this;
    }

    public RandomGraphBuilder weightRange(int min, int max) {
        configuration.setMinWeight(min);
        configuration.setMaxWeight(max);
        return this;
    }

    public RandomGraphBuilder mutable() {
        configuration.setImmutable(false);
        return this;
    }

    public RandomGraphBuilder immutable() {
        configuration.setImmutable(true);
        return this;
    }

    public IGraph generate() {

        return new RandomGraphGenerator<>(configuration)
                .generate();
    }
}
