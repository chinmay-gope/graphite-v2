package io.graphite.builder;

import io.graphite.graph.GraphFactory;
import io.graphite.graph.UndirectedGraph;

public final class UndirectedGraphBuilder extends AbstractGraphBuilder<UndirectedGraph, UndirectedGraphBuilder> {
    @Override
    protected UndirectedGraph createGraph() {
        return GraphFactory.undirected(configuration);
    }
}
