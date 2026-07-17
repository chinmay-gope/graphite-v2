package io.graphite.algorithm.examples.connectivity;

import io.graphite.algorithm.connectivity.BridgeFinder;
import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.algorithm.connectivity.BridgeAlgorithm;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.result.BridgeResult;
import io.graphite.algorithm.builder.Graphs;
import io.graphite.algorithm.util.GraphPrinter;

public class BridgeDemo {
    static void main() {
        Graph graph = Graphs
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Bridge Detection", graph);
        GraphPrinter.printEdges(graph);

        BridgeAlgorithm algorithm = new BridgeFinder();

        BridgeResult result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = Graphs
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Every edge is a bridge", graph);
        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = Graphs
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();
        GraphDemoPrinter.printHeader("No Bridges", graph);
//        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result.bridges());

        graph = Graphs
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Classical Example", graph);
        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = Graphs
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Disconnected graph", graph);
        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result);
    }
}
