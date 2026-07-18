package io.graphite.graph;

import io.graphite.builder.GraphConfiguration;
import io.graphite.exception.graph.InvalidVertexException;
import io.graphite.model.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class Graph implements IGraph {

    // ==========================================================
    // Fields
    // ==========================================================

    protected int edgeCount;

    protected final List<List<Edge>> adjacencyList;

    protected final GraphConfiguration configuration;

    // ==========================================================
    // Constructor
    // ==========================================================

    protected Graph(GraphConfiguration configuration) {
        this.configuration = configuration;

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < configuration.getVertices(); i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // ==========================================================
    // Internal Helpers
    // ==========================================================

    protected GraphConfiguration configuration() {
        return configuration;
    }

    // ==========================================================
    // Validation
    // ==========================================================

    protected void validateVertex(int vertex) {

        if (!containsVertex(vertex)) {
            throw new InvalidVertexException(vertex);
        }
    }

    // ==========================================================
    // Queries
    // ==========================================================

    @Override
    public boolean containsVertex(int vertex) {
        return vertex >= 0 && vertex < configuration.getVertices();
    }

    @Override
    public int degree(int vertex) {

        validateVertex(vertex);

        return adjacencyList.get(vertex).size();
    }

    @Override
    public boolean hasEdge(
            int source,
            int destination) {

        validateVertex(source);
        validateVertex(destination);

        return adjacencyList.get(source)
                .stream()
                .anyMatch(edge ->
                        edge.destination() == destination);
    }

    // ==========================================================
    // Views
    // ==========================================================

    @Override
    public List<Edge> getNeighbours(int vertex) {

        validateVertex(vertex);

        return Collections.unmodifiableList(
                adjacencyList.get(vertex));
    }

    @Override
    public List<Edge> getEdges() {

        List<Edge> edges = new ArrayList<>();

        for (List<Edge> neighbours : adjacencyList) {
            edges.addAll(neighbours);
        }

        return List.copyOf(edges);
    }

    // ==========================================================
    // Metadata
    // ==========================================================

    @Override
    public int getVertices() {
        return configuration.getVertices();
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public boolean isWeighted() {
        return configuration.isWeighted();
    }

    @Override
    public boolean isEmpty() {
        return configuration.getVertices() == 0;
    }

    @Override
    public boolean isDirected() {
        return configuration.isDirected();
    }

    @Override
    public boolean isUndirected() {
        return configuration.isUndirected();
    }

    // ==========================================================
    // Mutation
    // ==========================================================

    @Override
    public void clear() {

        adjacencyList.forEach(List::clear);

        edgeCount = 0;
    }


    // ==========================================================
    // Abstract
    // ==========================================================

    @Override
    public abstract void addEdge(
            int source,
            int destination,
            int weight);

    @Override
    public abstract void removeEdge(
            int source,
            int destination);

    @Override
    public IGraph copy() {
        return GraphCopier.copy(this);
    }

    @Override
    public IGraph transpose() {
        return GraphTransposer.transpose(this);
    }
}
