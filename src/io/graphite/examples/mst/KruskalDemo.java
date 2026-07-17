package io.graphite.examples.mst;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.MSTAlgorithm;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.Graph;
import io.graphite.result.MSTResult;
import io.graphite.util.GraphPrinter;

public class KruskalDemo {
    static void main() {
        Graph graph = Graphs
                .undirected(5)
                .addEdge(0, 1, 2)
                .addEdge(0, 3, 6)
                .addEdge(1, 2, 3)
                .addEdge(1, 3, 8)
                .addEdge(1, 4, 5)
                .addEdge(2, 3, 5)
                .addEdge(0, 1, 5)
                .addEdge(2, 4, 7)
                .addEdge(3, 4, 9)
                .build();

        GraphDemoPrinter.printHeader("Kruskal MST", graph);
        GraphPrinter.print(graph);

        MSTAlgorithm algorithm = new Kruskal();

        graph = Graphs
                .undirected(4)
                .addEdge(0, 1, 1)
                .addEdge(0, 2, 1)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 2)
                .addEdge(2, 3, 2)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Equal Weights", graph);
        GraphPrinter.print(graph);
        MSTResult result = algorithm.findMST(graph, 0);
        System.out.println(result);

        graph = Graphs
                .undirected(1)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Single", graph);
        GraphPrinter.print(graph);
        result = algorithm.findMST(graph, 0);
        System.out.println(result);

        graph = Graphs
                .undirected(6)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 4)
                .addEdge(1, 2, 2)
                .addEdge(1, 3, 5)
                .addEdge(2, 3, 5)
                .addEdge(2, 4, 11)
                .addEdge(3, 4, 2)
                .addEdge(3, 5, 1)
                .addEdge(4, 5, 7)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Cycle Heavy", graph);
        GraphPrinter.print(graph);
        result = algorithm.findMST(graph, 0);
        System.out.println(result);

        graph = Graphs
                .undirected(10)
                .addEdge(0, 1, 3)
                .addEdge(0, 2, 15)
                .addEdge(1, 3, 128)
                .addEdge(2, 4, 9999)
                .addEdge(3, 5, 42)
                .addEdge(4, 6, 7)
                .addEdge(5, 7, 1024)
                .addEdge(6, 8, 250)
                .addEdge(7, 9, 89)
                .addEdge(8, 9, 1)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Dynamic Inter Width", graph);
        GraphPrinter.print(graph);
        result = algorithm.findMST(graph, 0);
        System.out.println(result);

        try {
            graph = Graphs
                    .undirected(6)
                    .addEdge(0, 1, 4)
                    .addEdge(1, 2, 2)
                    .addEdge(3, 4, 1)
                    .build();
            GraphDemoPrinter.printHeader("Kruskal MST Disconnected Graph", graph);
            result = algorithm.findMST(graph, 0);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
