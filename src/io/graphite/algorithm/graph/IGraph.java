package io.graphite.algorithm.graph;

import io.graphite.algorithm.model.Edge;

import java.util.List;

public interface IGraph {

    void addEdge(int source, int destination);

    void addEdge(int source, int destination, int weight);

    void removeEdge(int source, int destination);

    List<Edge> getNeighbours(int vertex);

    List<List<Edge>> getAdjacencyList();

    int getVertices();

    int edgeCount();

    boolean isEmpty();

    GraphType getGraphType();

    IGraph transpose(IGraph graph);
}
