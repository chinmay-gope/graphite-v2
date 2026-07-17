package io.graphite.builder;

import io.graphite.graph.DirectedGraph;

public final class DirectedGraphBuilder extends AbstractGraphBuilder<DirectedGraph> {
    @Override
    public DirectedGraph build() {
        BuilderValidator.validate(configuration);
        return new DirectedGraph(configuration);
    }
}
