package io.graphite;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;
import io.graphite.print.GraphPrinter;

public class Main {
    static void main() {
        IGraph graph = Graphs
                .directed()
                .vertices(5)
                .weighted(true)
                .immutable(true)
                .addEdge(0, 1, 3)
                .addEdge(1, 2, 3)
                .build();

//        graph.addEdge(0,4);
        System.out.println("Graph as mutable: " + graph.asImmutable().getClass()); // throws : This graph is immutable.

        GraphPrinter.compact(graph); // print() also uses same formatter
        GraphPrinter.edgeList(graph);
        GraphPrinter.matrix(graph);
        GraphPrinter.statistics(graph);
    }
}
