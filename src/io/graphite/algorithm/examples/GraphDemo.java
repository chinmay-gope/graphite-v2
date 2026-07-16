package io.graphite.algorithm.examples;

import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.builder.GraphBuilder;
import io.graphite.algorithm.util.GraphPrinter;
import io.graphite.algorithm.util.GraphUtils;

public class GraphDemo {

    static void main() {

        Graph graph = GraphBuilder
                .directed(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .addEdge(3, 5)
                .build();

        GraphPrinter.print(graph);
        System.out.println("\nEdge Count : " + GraphUtils.edgeCount(graph));

        Graph g2 = GraphUtils.transpose(graph);
        System.out.println("\nTransposed Graph : ");
        GraphPrinter.print(g2);
    }
}
