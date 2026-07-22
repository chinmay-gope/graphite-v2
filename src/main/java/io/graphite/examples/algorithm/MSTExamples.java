package io.graphite.examples.algorithm;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;

public final class MSTExamples {

    private static final IGraph GRAPH =
            Graphs.undirected()
                    .weighted(true)
                    .addEdge(0, 1, 4)
                    .addEdge(0, 2, 3)
                    .addEdge(1, 2, 1)
                    .addEdge(1, 3, 2)
                    .addEdge(2, 3, 4)
                    .addEdge(3, 4, 2)
                    .addEdge(4, 5, 6)
                    .build();

    private MSTExamples() {
    }

    private static void prim() {

        ExamplePrinter.feature("Prim's Algorithm");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.mst().prim(0)"
        );

        ExamplePrinter.result(
                GRAPH.mst().prim(0)
        );
    }

    private static void kruskal() {

        ExamplePrinter.feature("Kruskal's Algorithm");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.mst().kruskal()"
        );

        ExamplePrinter.result(
                GRAPH.mst().kruskal()
        );
    }

    public static void run() {

        ExamplePrinter.title("Minimum Spanning Tree Examples");

        prim();

        kruskal();
    }
}
