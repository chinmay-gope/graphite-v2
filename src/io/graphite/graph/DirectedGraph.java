package io.graphite.algorithm.graph;

import io.graphite.builder.GraphConfiguration;
import io.graphite.algorithm.model.Edge;

public final class DirectedGraph extends Graph {

    public DirectedGraph(GraphConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void addEdge(int source, int destination, int weight) {

        validateVertex(source);
        validateVertex(destination);

        adjacencyList.get(source)
                .add(new Edge(source, destination, weight));

        edgeCount++;
    }

    @Override
    public void removeEdge(int source, int destination) {

        validateVertex(source);
        validateVertex(destination);

        boolean removed = adjacencyList.get(source)
                .removeIf(edge -> edge.destination() == destination);

        if (removed) {
            edgeCount--;
        }
    }

    @Override
    public DirectedGraph copy() {

        DirectedGraph copy = new DirectedGraph(configuration());

        for (Edge edge : getEdges()) {
            copy.addEdge(
                    edge.source(),
                    edge.destination(),
                    edge.weight());
        }

        return copy;
    }

    @Override
    public DirectedGraph transpose() {

        DirectedGraph transpose = new DirectedGraph(configuration());

        for (Edge edge : getEdges()) {
            transpose.addEdge(
                    edge.destination(),
                    edge.source(),
                    edge.weight());
        }

        return transpose;
    }
}
