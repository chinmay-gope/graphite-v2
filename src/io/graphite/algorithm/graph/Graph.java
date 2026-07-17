package io.graphite.algorithm.graph;

import io.graphite.algorithm.builder.GraphConfiguration;
import io.graphite.algorithm.exception.graph.InvalidVertexException;
import io.graphite.algorithm.model.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public abstract class Graph implements IGraph {

    // ==========================================================
    // Fields
    // ==========================================================

    protected int edgeCount;

    protected final int vertices;

    protected final boolean weighted;

    protected final List<List<Edge>> adjacencyList;

    // ==========================================================
    // Constructor
    // ==========================================================

    protected Graph(GraphConfiguration configuration) {

        this.vertices = configuration.getVertices();

        this.weighted = configuration.isWeighted();

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
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
    // Vertex Queries
    // ==========================================================

    @Override
    public boolean containsVertex(int vertex) {
        return vertex >= 0 && vertex < vertices;
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
    // Graph Views
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

    @Override
    public List<List<Edge>> getAdjacencyList() {

        return Collections.unmodifiableList(
                adjacencyList);
    }

    // ==========================================================
    // Graph Metadata
    // ==========================================================

    @Override
    public int getVertices() {
        return vertices;
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public boolean isWeighted() {
        return weighted;
    }

    @Override
    public boolean isEmpty() {
        return vertices == 0;
    }

    protected GraphConfiguration configuration() {
        GraphConfiguration config = new GraphConfiguration();

        config.setWeighted(weighted);
        config.setVertices(vertices);

        return config;
    }

    // ==========================================================
    // Graph Operations
    // ==========================================================

    @Override
    public void clear() {

        adjacencyList.forEach(List::clear);

        edgeCount = 0;
    }


    // ==========================================================
    // Abstract Operations
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
    public abstract IGraph copy();

    @Override
    public abstract IGraph transpose();
}
