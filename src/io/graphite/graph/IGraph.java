package io.graphite.graph;

import io.graphite.model.Edge;

import java.util.List;

public interface IGraph {

    // ========= Mutation =========

    void addEdge(int source, int destination, int weight);

    void removeEdge(int source, int destination);

    void clear();


    // ========= Queries =========

    boolean hasEdge(int source, int destination);

    boolean containsVertex(int vertex);

    int degree(int vertex);

    boolean isEmpty();

    boolean isWeighted();


    // ========= Views =========

    List<Edge> getNeighbours(int vertex);

    List<Edge> getEdges();

    List<List<Edge>> getAdjacencyList();


    // ========= Metadata =========

    int getVertices();

    int edgeCount();


    // ========= Copy =========

    IGraph copy();


    // ========= Transform =========

    IGraph transpose();
}
