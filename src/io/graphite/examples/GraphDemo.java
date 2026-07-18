package io.graphite.examples;

import io.graphite.builder.Graphs;
import io.graphite.graph.Graph;
import io.graphite.graph.IGraph;
import io.graphite.util.GraphPrinter;

public class GraphDemo {

    static void main() {

        Graph graph = Graphs
                .directed(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .addEdge(3, 5)
                .build();

        GraphPrinter.print(graph);
        System.out.println("\nEdge Count : " + graph.edgeCount());

        IGraph g2 = graph.transpose();
        System.out.println("\nTransposed Graph : ");
        GraphPrinter.print(g2);
    }
}
