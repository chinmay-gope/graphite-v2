package io.graphite.algorithm.graph;

import io.graphite.algorithm.model.Edge;

public class UnDirectedGraph extends Graph {
    public UnDirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        validateVertex(source);
        validateVertex(destination);

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));

        edgeCount++;
    }

    @Override
    public GraphType getGraphType() {
        return GraphType.UNDIRECTED;
    }
}
