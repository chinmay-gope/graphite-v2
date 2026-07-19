package io.graphite;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;
import io.graphite.print.GraphPrinter;

public class Main {
    static void main() {
        IGraph graph = Graphs
                .undirected()
                .vertices(5)
                .weighted(true)
                .addEdge(0, 1, 3)
                .addEdge(1, 2, 3)
                .build();

        GraphPrinter.compact(graph); // print() also uses same formatter
        GraphPrinter.edgeList(graph);
        GraphPrinter.tree(graph);
    }
}
