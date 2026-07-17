package io.graphite.builder;

import io.graphite.graph.UndirectedGraph;

public final class UndirectedGraphBuilder extends AbstractGraphBuilder<UndirectedGraph, UndirectedGraphBuilder> {
    @Override
    protected UndirectedGraph createGraph() {
        return new UndirectedGraph(configuration);
    }

    @Override
    public UndirectedGraph build() {
        BuilderValidator.validate(configuration);
        return new UndirectedGraph(configuration);
    }
}
