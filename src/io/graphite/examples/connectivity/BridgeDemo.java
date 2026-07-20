package io.graphite.examples.connectivity;

import io.graphite.algorithm.connectivity.BridgeAlgorithm;
import io.graphite.algorithm.connectivity.BridgeFinder;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.graph.IGraph;
import io.graphite.result.BridgeResult;
import io.graphite.util.GraphPrinter;

public class BridgeDemo {
    static void main() {
        IGraph graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Bridge Detection", graph);
        GraphPrinter.printEdges(graph);

        BridgeAlgorithm algorithm = BridgeFinder.INSTANCE;

        BridgeResult result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = Graphs
                .undirected()
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
                .undirected()
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
                .undirected()
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
                .undirected()
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
