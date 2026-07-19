package io.graphite.graph;

import io.graphite.api.io.GraphWriterService;
import io.graphite.builder.GraphConfiguration;
import io.graphite.model.Edge;

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
}
