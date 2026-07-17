package io.graphite.builder;

import io.graphite.graph.UndirectedGraph;

public final class UndirectedGraphBuilder extends AbstractGraphBuilder<UndirectedGraph> {
    @Override
    public UndirectedGraph build() {
        BuilderValidator.validate(configuration);
        return new UndirectedGraph(configuration);
    }
}
