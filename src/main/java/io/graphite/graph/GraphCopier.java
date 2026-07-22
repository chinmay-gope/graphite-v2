package main.java.io.graphite.graph;

import main.java.io.graphite.model.Edge;

public final class GraphCopier {
    private GraphCopier() {
    }

    public static Graph copy(Graph graph) {

        Graph copy = graph.configuration().isDirected()
                ? GraphFactory.directed(graph.configuration())
                : GraphFactory.undirected(graph.configuration());

        for (Edge edge : graph.getEdges()) {
            copy.addEdge(
                    edge.source(),
                    edge.destination(),
                    edge.weight());
        }

        return copy;
    }
}
