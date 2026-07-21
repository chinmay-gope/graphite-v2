package io.graphite.graph;

import io.graphite.api.*;
import io.graphite.api.analysis.GraphAnalysis;
import io.graphite.io.writer.GraphWriterService;
import io.graphite.model.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IGraph {

    GraphWriterService write();

    // ========= Mutation =========

    void addEdge(int source, int destination, int weight);

    default void addEdge(int source, int destination) {
        addEdge(source, destination, 1);
    }

    void removeEdge(int source, int destination);

    void clear();

    IGraph asImmutable();

    // ========= Queries =========

    boolean hasEdge(int source, int destination);

    boolean containsVertex(int vertex);

    int degree(int vertex);

    boolean isEmpty();

    boolean isWeighted();

    boolean isDirected();

    boolean isUndirected();


    // ========= Views =========

    List<Edge> getNeighbors(int vertex);

    default List<Edge> neighbors(int vertex) {
        return getNeighbors(vertex);
    }

    List<Edge> getEdges();

    default List<Edge> edges() {
        return getEdges();
    }

    // ========= Metadata =========

    int getVertices();

    default int vertexCount() {
        return getVertices();
    }

    int edgeCount();

    default Iterable<Integer> vertices() {

        List<Integer> vertices = new ArrayList<>();

        for (int i = 0; i < vertexCount(); i++) {
            vertices.add(i);
        }

        return Collections.unmodifiableList(vertices);
    }

    default boolean contains(int vertex) {
        return containsVertex(vertex);
    }

    // ========= Copy =========

    IGraph copy();


    // ========= Transform =========

    IGraph transpose();

    // ========= Services =========

    Bipartite bipartite();

    Connectivity connectivity();

    Cycle cycle();

    Euler euler();

    ShortestPath shortestPath();

    Topology topology();

    MST mst();

    Traversal traversal();

    GraphAnalysis analysis();
}
