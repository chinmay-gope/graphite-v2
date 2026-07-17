package io.graphite.algorithm.builder;

import io.graphite.algorithm.graph.DirectedGraph;

public final class DirectedGraphBuilder extends AbstractGraphBuilder<DirectedGraph> {
    @Override
    public DirectedGraph build() {
        BuilderValidator.validate(configuration);
        return new DirectedGraph(configuration);
    }
}
