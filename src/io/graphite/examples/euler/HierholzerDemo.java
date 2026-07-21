package io.graphite.examples.euler;

import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.result.EulerResult;
import io.graphite.util.GraphPrinter;

public class HierholzerDemo {

    static void main(String[] args) {
        // Demo 1: Simple cycle
        runDemo("Euler - 4-cycle",
                Graphs.undirected()
                        .vertices(5)
                        .addEdge(0, 1)
                        .addEdge(1, 2)
                        .addEdge(2, 3)
                        .addEdge(3, 0)
                        .build());

        // Demo 2: Empty graph
        runDemo("Euler - empty",
                Graphs.undirected()
                        .vertices(5)
                        .build());

        // Demo 3: Path graph (no Euler circuit)
        runDemoWithException("Euler - path graph",
                Graphs.undirected()
                        .vertices(5)
                        .addEdge(0, 1)
                        .addEdge(1, 2)
                        .addEdge(2, 3)
                        .build());

        // Demo 4: Disconnected graph
        runDemoWithException("Euler - disconnected",
                Graphs.undirected()
                        .vertices(5)
                        .addEdge(0, 1)
                        .addEdge(1, 2)
                        .addEdge(3, 4)
                        .build());
    }

    private static void runDemo(String title, IGraph graph) {
        GraphDemoPrinter.printHeader(title, graph);
        GraphPrinter.print(graph);

        EulerResult circuit = Hierholzer.INSTANCE.findEulerCircuit(graph);
        EulerResult path = Hierholzer.INSTANCE.findEulerPath(graph);

        System.out.println("Circuit: " + circuit);
        System.out.println("Path: " + path);
        System.out.println();
    }

    private static void runDemoWithException(String title, IGraph graph) {
        GraphDemoPrinter.printHeader(title, graph);
        GraphPrinter.print(graph);
        try {
            EulerResult circuit = Hierholzer.INSTANCE.findEulerCircuit(graph);
            EulerResult path = Hierholzer.INSTANCE.findEulerPath(graph);

            System.out.println("Circuit: " + circuit);
            System.out.println("Path: " + path);
        } catch (GraphException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
}
