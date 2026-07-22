package main.java.io.graphite.graph;

import main.java.io.graphite.model.Edge;

public final class GraphTransposer {

    private GraphTransposer() {
    }

    public static Graph transpose(Graph graph) {

        if (graph.configuration().isUndirected()) {
            return GraphCopier.copy(graph);
        }

        Graph transpose =
                GraphFactory.directed(graph.configuration());

        for (Edge edge : graph.getEdges()) {

            transpose.addEdge(
                    edge.destination(),
                    edge.source(),
                    edge.weight()
            );
        }

        return transpose;
    }
}
