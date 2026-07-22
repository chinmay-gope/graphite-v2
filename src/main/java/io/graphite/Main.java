package main.java.io.graphite;

import main.java.io.graphite.builder.Graphs;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.print.GraphPrinter;

public class Main {
    static void main() {
        IGraph graph = Graphs
                .random()
                .vertices(3)
                .edges(3)
                .immutable()
                .build();

//        graph.addEdge(0,4);
        System.out.println("Graph as mutable: " + graph.asImmutable().getClass()); // throws : This graph is immutable.

        GraphPrinter.compact(graph); // print() also uses same formatter
        GraphPrinter.edgeList(graph);
        GraphPrinter.matrix(graph);
        GraphPrinter.statistics(graph);
        GraphPrinter.dot(graph);
        GraphPrinter.mermaid(graph);
        GraphPrinter.json(graph);
    }
}
