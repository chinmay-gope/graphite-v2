package io.graphite.algorithm.examples.connectivity;

import io.graphite.algorithm.connectivity.BiconnectedComponents;
import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.algorithm.connectivity.BiconnectedAlgorithm;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.result.BiConnectedResult;
import io.graphite.algorithm.builder.GraphBuilder;
import io.graphite.algorithm.util.GraphPrinter;

public class BiConnectedDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Triangle", graph);
        GraphPrinter.print(graph);

        BiconnectedAlgorithm algorithm = new BiconnectedComponents();

        BiConnectedResult result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2)
                .addEdge(0, 2)
                .addEdge(2, 3)
                .addEdge(2, 4)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Two Triangles Sharing One Vertex", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2)
                .addEdge(2, 3)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Triangle Connected by Bridge", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 3)
                .addEdge(3, 2)
                .addEdge(2, 4)
                .addEdge(5, 4)
                .addEdge(5, 6)
                .addEdge(4, 6)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Bridge Between Two Cycles", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .addEdge(0, 4)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Star", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 3)
                .addEdge(2, 3)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Complete Graph K4", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(4, 3)
                .addEdge(5, 3)
                .addEdge(5, 6)
                .addEdge(6, 4)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Disconnected Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(0, 3)
                .addEdge(2, 4)
                .addEdge(5, 4)
                .addEdge(6, 4)
                .addEdge(5, 4)
                .build();
        GraphDemoPrinter.printHeader("BiConnected CLRS Example", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 2,4)
                .addEdge(1, 3,5)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("BiConnected Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.findBiconnectedComponents(graph);
        System.out.println(result);
    }
}
