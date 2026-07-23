package io.graphite.examples;

import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;
import io.graphite.print.GraphPrinter;

public final class MainExamples {
    public static void main(String[] args) {
        IGraph graph = Graphs.directed()
                .addEdge(2,4)
                .build();

        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(i + " : " + graph.isActiveVertex(i));
        }

        checkImmutability();
    }

    private static void checkImmutability() {
        IGraph graph = Graphs.undirected().immutable(true)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .build();

        GraphPrinter.println(graph);
        System.out.println("____________________");

        IGraph graph3 = Graphs.undirected()
                .addEdges(graph.edges())
                .build();

        graph3.removeEdge(0, 1);

        GraphPrinter.println(graph3);
    }

}
