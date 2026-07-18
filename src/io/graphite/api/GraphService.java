package io.graphite.api;

import io.graphite.graph.IGraph;

public abstract class GraphService {
    protected final IGraph graph;

    protected GraphService(IGraph graph) {
        this.graph = graph;
    }
}
