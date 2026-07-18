package io.graphite.examples.mst;

import io.graphite.algorithm.mst.Prim;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.Graph;
import io.graphite.result.MSTResult;
import io.graphite.util.GraphPrinter;

public class PrimDemo {
    static void main() {
        Graph graph = Graphs
                .undirected()
                .addEdge(0, 1, 2)
                .addEdge(0, 3, 6)
                .addEdge(1, 2, 3)
                .addEdge(1, 3, 8)
                .addEdge(1, 4, 5)
                .addEdge(2, 4, 7)
                .addEdge(3, 4, 9)
                .build();

        GraphDemoPrinter.printHeader("Prim MST", graph);
        GraphPrinter.print(graph);

        Prim algorithm = new Prim();

        MSTResult result = algorithm.findMST(graph, 0);

        System.out.println(result);

        graph = Graphs
                .undirected()
                .addEdge(0, 1, 1)
                .addEdge(0, 2, 1)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 2)
                .addEdge(2, 3, 2)
                .build();

        GraphDemoPrinter.printHeader("Prim MST With Multiple Equal Weights", graph);
        GraphPrinter.print(graph);

        result = algorithm.findMST(graph, 0);
        System.out.println(result);

        graph = Graphs
                .undirected()
                .build();
        GraphDemoPrinter.printHeader("Prim MST With Single Vertex", graph);
        GraphPrinter.print(graph);
        result = algorithm.findMST(graph, 0);
        System.out.println(result);


        graph = Graphs
                .undirected()
                .addEdge(0, 1, 1)
                .addEdge(1, 2, -1)
                .addEdge(2, 3, -1)
                .addEdge(3, 1, -1)
                .build();

        GraphDemoPrinter.printHeader("Prim MST With Negative Weight Cycle", graph);
        GraphPrinter.print(graph);
        result = algorithm.findMST(graph, 0);
        System.out.println(result);

        try {
            graph = Graphs
                    .undirected()
                    .addEdge(0, 1, 4)
                    .addEdge(1, 2, 2)
                    .addEdge(3, 4, 1)
                    .build();

            GraphDemoPrinter.printHeader("Prim MST With Disconnected Graph", graph);
            GraphPrinter.print(graph);

            result = algorithm.findMST(graph, 0);
            System.out.println(result);

        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
