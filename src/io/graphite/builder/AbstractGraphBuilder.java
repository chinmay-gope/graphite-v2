package io.graphite.builder;

import io.graphite.graph.Graph;

public abstract class AbstractGraphBuilder<T extends Graph> {
    protected final GraphConfiguration configuration =
            new GraphConfiguration();

    public AbstractGraphBuilder<T> vertices(int vertices) {
        configuration.setVertices(vertices);
        return this;
    }

    public AbstractGraphBuilder<T> weighted(boolean weighted) {
        configuration.setWeighted(weighted);
        return this;
    }

    public AbstractGraphBuilder<T> weightRange(int min, int max) {
        configuration.setWeighted(true);
        configuration.setMinWeight(min);
        configuration.setMaxWeight(max);

        return this;
    }

    public AbstractGraphBuilder<T> selfLoops(boolean enabled) {
        configuration.setSelfLoops(enabled);
        return this;
    }

    public AbstractGraphBuilder<T> parallelEdges(boolean enabled) {
        configuration.setParallelEdges(enabled);
        return this;
    }

    public AbstractGraphBuilder<T> immutable(boolean enabled) {
        configuration.setImmutable(enabled);
        return this;
    }

    public abstract T build();
}
