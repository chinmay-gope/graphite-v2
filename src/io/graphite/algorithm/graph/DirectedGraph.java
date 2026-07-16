package io.graphite.algorithm.graph;

import io.graphite.algorithm.model.Edge;

public class DirectedGraph extends Graph {
    public DirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        validateVertex(source);
        validateVertex(destination);

        adjacencyList.get(source).add(new Edge(destination, weight));
        
        edgeCount++;
    }

    @Override
    public GraphType getGraphType() {
        return GraphType.DIRECTED;
    }
}
