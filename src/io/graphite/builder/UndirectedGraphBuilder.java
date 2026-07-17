package io.graphite.algorithm.builder;

import io.graphite.algorithm.graph.UndirectedGraph;

public final class UndirectedGraphBuilder extends AbstractGraphBuilder<UndirectedGraph> {
    @Override
    public UndirectedGraph build() {
        BuilderValidator.validate(configuration);
        return new UndirectedGraph(configuration);
    }
}
