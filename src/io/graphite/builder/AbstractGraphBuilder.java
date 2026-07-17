package io.graphite.builder;

import io.graphite.graph.Graph;

public abstract class AbstractGraphBuilder<G extends Graph, SELF extends AbstractGraphBuilder<G, SELF>> {
    protected final GraphConfiguration configuration = new GraphConfiguration();

    protected G graph;

    protected abstract G createGraph();

    @SuppressWarnings("unchecked")
    protected final SELF self() {
        return (SELF) this;
    }

    protected final G graph() {
        if (graph == null) {
            graph = createGraph();
        }

        return graph;
    }

    public SELF vertices(int vertices) {
        configuration.setVertices(vertices);
        return self();
    }

    public SELF weighted(boolean weighted) {
        configuration.setWeighted(weighted);
        return self();
    }

    public SELF immutable(boolean immutable) {
        configuration.setImmutable(immutable);
        return self();
    }

    public SELF selfLoops(boolean immutable) {
        configuration.setSelfLoops(immutable);
        return self();
    }

    public SELF parallelEdges(boolean immutable) {
        configuration.setParallelEdges(immutable);
        return self();
    }

    public SELF addEdge(
            int source,
            int destination) {
        graph().addEdge(source, destination, 1);

        return self();
    }

    public SELF addEdge(
            int source,
            int destination,
            int weight) {
        graph().addEdge(source, destination, weight);

        return self();
    }

    public SELF clear() {
        graph().clear();

        return self();
    }

    public G build() {
        BuilderValidator.validate(configuration);

        return graph();
    }
}
