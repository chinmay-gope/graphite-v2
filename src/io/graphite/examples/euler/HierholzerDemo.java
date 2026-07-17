package io.graphite.algorithm.examples.euler;

import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.Graph;
import io.graphite.result.EulerResult;
import io.graphite.builder.Graphs;
import io.graphite.util.GraphPrinter;

public class HierholzerDemo {
    static void main() {
        Graph graph = Graphs
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        GraphDemoPrinter.printHeader("Euler", graph);
        GraphPrinter.print(graph);
        EulerResult circuit = new Hierholzer().findEulerCircuit(graph);
        EulerResult path = new Hierholzer().findEulerPath(graph);

        System.out.println(circuit);
        System.out.println(path);

        graph = Graphs
                .undirected(1)
                .build();
        GraphDemoPrinter.printHeader("Euler", graph);
        GraphPrinter.print(graph);
        circuit = new Hierholzer().findEulerCircuit(graph);
        path = new Hierholzer().findEulerPath(graph);
        System.out.println(circuit);
        System.out.println(path);

        try {
            graph = Graphs
                    .undirected(4)
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(2, 3)
                    .build();

            System.out.println();
            GraphPrinter.print(graph);
            System.out.println("undirected graph - 4");

            new Hierholzer().findEulerCircuit(graph);
            new Hierholzer().findEulerCircuit(graph);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }

        try {
            graph = Graphs
                    .undirected(6)
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(3, 4)
                    .build();
            System.out.println();
            GraphPrinter.print(graph);
            System.out.println("undirected graph - 6");

            new Hierholzer().findEulerCircuit(graph);
            new Hierholzer().findEulerPath(graph);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
