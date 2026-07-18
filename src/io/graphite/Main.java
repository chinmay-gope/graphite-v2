package io.graphite;

import io.graphite.builder.Graphs;
import io.graphite.graph.Graph;
import io.graphite.util.GraphPrinter;

public class Main {
    static void main() {
        Graph graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .build();

        GraphPrinter.print(graph);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 5)
                .addEdge(1, 2, 7)
                .addEdge(2, 3, 9)
                .build();

        GraphPrinter.print(graph);
    }
}
