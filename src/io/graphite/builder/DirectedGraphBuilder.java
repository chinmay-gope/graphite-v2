package io.graphite.builder;

import io.graphite.graph.DirectedGraph;
import io.graphite.graph.GraphFactory;

public final class DirectedGraphBuilder extends AbstractGraphBuilder<DirectedGraph, DirectedGraphBuilder> {


    @Override
    protected DirectedGraph createGraph() {
        return GraphFactory.directed(configuration);
    }

    @Override
    public DirectedGraph build() {
        BuilderValidator.validate(configuration);
        return new DirectedGraph(configuration);
    }
}
