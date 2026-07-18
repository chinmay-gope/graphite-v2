package io.graphite.graph;

import io.graphite.model.Edge;

public final class GraphTransposer {

    private GraphTransposer() {
        throw new AssertionError("Utility class");
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
