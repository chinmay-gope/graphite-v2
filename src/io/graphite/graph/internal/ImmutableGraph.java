package io.graphite.graph.internal;

import io.graphite.api.*;
import io.graphite.api.analysis.GraphAnalysis;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

import java.util.List;

public final class ImmutableGraph implements IGraph {

    private final IGraph graph;

    public ImmutableGraph(IGraph graph) {
        this.graph = graph;
    }

    private UnsupportedOperationException immutable() {
        return new UnsupportedOperationException(
                "This graph is immutable.");
    }

    // ==========================================================
    // Mutating Operations
    // ==========================================================

    @Override
    public void addEdge(int source, int destination, int weight) {
        throw immutable();
    }

    @Override
    public void removeEdge(int source, int destination) {
        throw immutable();
    }

    @Override
    public void clear() {
        throw immutable();
    }

    // ==========================================================
    // Queries
    // ==========================================================

    @Override
    public boolean hasEdge(int source, int destination) {
        return graph.hasEdge(source, destination);
    }

    @Override
    public boolean containsVertex(int vertex) {
        return graph.containsVertex(vertex);
    }

    @Override
    public int degree(int vertex) {
        return graph.degree(vertex);
    }

    @Override
    public boolean isEmpty() {
        return graph.isEmpty();
    }

    @Override
    public boolean isWeighted() {
        return graph.isWeighted();
    }

    @Override
    public boolean isDirected() {
        return graph.isDirected();
    }


    @Override
    public boolean isUndirected() {
        return graph.isUndirected();
    }

    @Override
    public boolean isImmutable() {
        return true;
    }

    @Override
    public List<Edge> getNeighbors(int vertex) {
        return graph.getNeighbors(vertex);
    }

    @Override
    public List<Edge> getEdges() {
        return graph.getEdges();
    }

    @Override
    public int getVertices() {
        return graph.getVertices();
    }

    // ==========================================================
    // Metadata
    // ==========================================================

    @Override
    public int vertexCount() {
        return graph.vertexCount();
    }

    @Override
    public int edgeCount() {
        return graph.edgeCount();
    }

    // ==========================================================
    // Copy
    // ==========================================================

    @Override
    public IGraph copy() {
        return graph.copy().asImmutable();
    }

    @Override
    public IGraph transpose() {
        return graph.transpose().asImmutable();
    }

//    ______________________________________________

    @Override
    public BipartiteService bipartite() {
        return graph.bipartite();
    }

    @Override
    public ConnectivityService connectivity() {
        return graph.connectivity();
    }

    @Override
    public CycleService cycle() {
        return graph.cycle();
    }

    @Override
    public EulerService euler() {
        return graph.euler();
    }

    @Override
    public ShortestPathService shortestPath() {
        return graph.shortestPath();
    }

    @Override
    public TopologyService topology() {
        return graph.topology();
    }

    @Override
    public MSTService mst() {
        return graph.mst();
    }

    @Override
    public TraversalService traversal() {
        return graph.traversal();
    }

    @Override
    public GraphAnalysis analysis() {
        return graph.analysis();
    }

    @Override
    public IGraph asImmutable() {
        return graph;
    }

}
