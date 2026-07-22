package io.graphite.examples.algorithm;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;

public final class CycleExamples {

    private static final IGraph DIRECTED =
            Graphs.directed()
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(2, 0)
                    .build();

    private static final IGraph UNDIRECTED =
            Graphs.undirected()
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(2, 3)
                    .addEdge(3, 1)
                    .build();

    private CycleExamples() {
    }

    private static void directedCycle() {

        ExamplePrinter.feature("Directed Cycle Detection");

        ExamplePrinter.graph(DIRECTED);

        ExamplePrinter.api(
                "graph.cycle().directed(()"
        );

        ExamplePrinter.result(
                DIRECTED.cycle().directed()
        );
    }

    private static void undirectedCycle() {

        ExamplePrinter.feature("Undirected Cycle Detection");

        ExamplePrinter.graph(UNDIRECTED);

        ExamplePrinter.api(
                "graph.cycle().undirected()"
        );

        ExamplePrinter.result(
                UNDIRECTED.cycle().undirected()
        );
    }

    public static void run() {

        ExamplePrinter.title("Cycle Detection Examples");

        directedCycle();

        undirectedCycle();
    }
}
