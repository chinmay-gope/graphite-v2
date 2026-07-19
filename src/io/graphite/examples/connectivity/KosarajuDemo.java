package io.graphite.examples.connectivity;

import io.graphite.algorithm.connectivity.Kosaraju;
import io.graphite.algorithm.connectivity.SCCAlgorithm;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.graph.IGraph;
import io.graphite.result.SCCResult;
import io.graphite.util.GraphPrinter;

public class KosarajuDemo {
    static void main() {
        IGraph graph = Graphs
                .directed()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();

        GraphDemoPrinter.printHeader("Kosaraju SCC", graph);
        GraphPrinter.print(graph);

        SCCAlgorithm algorithm = new Kosaraju();

        SCCResult result = algorithm.findSCCs(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 1)
                .addEdge(1, 2, 1)
                .addEdge(2, 0, 1)   // cycle 1
                .addEdge(3, 4, 1)
                .addEdge(4, 5, 1)
                .addEdge(5, 3, 1)   // cycle 2
                .build();
        GraphDemoPrinter.printHeader("Kosaraju SCC Multiple Disjoint Cycles", graph);
        GraphPrinter.print(graph);
        result = algorithm.findSCCs(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 1)
                .addEdge(1, 2, 1)
                .addEdge(2, 3, 1)
                .addEdge(3, 4, 1)
                .build();
        GraphDemoPrinter.printHeader("Kosaraju SCC Chain with One-Way Links", graph);
        GraphPrinter.print(graph);
        result = algorithm.findSCCs(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 1)
                .addEdge(1, 2, 1)
                .addEdge(2, 0, 1)   // SCC1
                .addEdge(2, 3, 1)
                .addEdge(3, 4, 1)
                .addEdge(4, 5, 1)
                .addEdge(5, 3, 1)   // SCC2
                .addEdge(6, 7, 1)
                .addEdge(7, 6, 1)   // SCC3
                .addEdge(7, 5, 1)   // cross edge SCC3 → SCC2
                .build();
        GraphDemoPrinter.printHeader("Kosaraju SCC Mixed Cycles and Cross Edges", graph);
        GraphPrinter.print(graph);
        result = algorithm.findSCCs(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 1)
                .addEdge(1, 0, 1)   // SCC1
                .addEdge(2, 3, 1)
                .addEdge(3, 4, 1)
                .addEdge(4, 2, 1)   // SCC2
                // nodes 5 and 6 isolated
                .build();
        GraphDemoPrinter.printHeader("Kosaraju SCC Isolated Nodes + Cycles", graph);
        GraphPrinter.print(graph);
        result = algorithm.findSCCs(graph);
        System.out.println(result);
    }
}
