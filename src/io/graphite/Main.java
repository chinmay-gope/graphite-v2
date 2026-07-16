package io.graphite;

import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.builder.GraphBuilder;
import io.graphite.algorithm.util.GraphPrinter;

public class Main {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .build();

        System.out.println("Undirected Adj List : " + graph.getAdjacencyList());
        GraphPrinter.print(graph);

        graph = GraphBuilder
                .directed(4)
                .addEdge(0, 1, 5)
                .addEdge(1, 2, 7)
                .addEdge(2, 3, 9)
                .build();

        System.out.println("Directed Adj List : " + graph.getAdjacencyList());
        GraphPrinter.print(graph);
    }
}
