package io.graphite.builder;

import io.graphite.graph.Graph;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractGraphBuilder<G extends Graph, SELF extends AbstractGraphBuilder<G, SELF>> {
    protected final GraphConfiguration configuration = new GraphConfiguration();

    protected final List<Edge> edges =
            new ArrayList<>();

    protected abstract G createGraph();

    @SuppressWarnings("unchecked")
    protected final SELF self() {
        return (SELF) this;
    }

    protected final List<Edge> edges() {
        return edges;
    }

    public boolean isEmpty() {
        return edges.isEmpty();
    }

    public int edgeCount() {
        return edges.size();
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

        return addEdge(
                source,
                destination,
                1
        );
    }

    public SELF addEdge(
            int source,
            int destination,
            int weight) {

        edges.add(new Edge(
                source,
                destination,
                weight));

        return self();
    }

    public SELF addEdge(Edge edge) {

        edges.add(edge);

        return self();
    }

    public SELF addEdges(Collection<Edge> edges) {

        this.edges.addAll(edges);

        return self();
    }

    public SELF clear() {

        edges.clear();

        configuration.setVertices(0);

        return self();
    }

    public SELF from(IGraph graph) {

        configuration.setVertices(graph.getVertices());
        configuration.setWeighted(graph.isWeighted());
        configuration.setDirected(graph.isDirected());

        addEdges(graph.getEdges());

        return self();
    }

    public IGraph build() {

        BuilderValidator.validate(configuration);

        G graph = createGraph();

        for (Edge edge : edges) {

            graph.addEdge(
                    edge.source(),
                    edge.destination(),
                    edge.weight());
        }

        System.out.println("Graph built with " + graph.getVertices() + " vertices and " + graph.getEdges().size() + " edges.");

        return configuration.isImmutable()
                ? graph.asImmutable()
                : graph;
    }
}
