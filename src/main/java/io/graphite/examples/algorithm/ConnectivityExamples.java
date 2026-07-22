package io.graphite.examples.algorithm;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;

public final class ConnectivityExamples {

    private static final IGraph UNDIRECTED =
            Graphs.undirected()
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(1, 3)
                    .addEdge(3, 4)
                    .addEdge(4, 5)
                    .addEdge(5, 3)
                    .build();

    private static final IGraph DIRECTED =
            Graphs.directed()
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(2, 0)
                    .addEdge(2, 3)
                    .addEdge(3, 4)
                    .addEdge(4, 3)
                    .build();

    private ConnectivityExamples() {
    }

    // ==========================================================
    // Undirected Graph Algorithms
    // ==========================================================

    private static void connectedComponents() {

        ExamplePrinter.feature("Connected Components");

        ExamplePrinter.graph(UNDIRECTED);

        ExamplePrinter.api(
                "graph.connectivity().biconnectedComponents()"
        );

        ExamplePrinter.result(
                UNDIRECTED.connectivity().biconnectedComponents()
        );
    }

    private static void bridges() {

        ExamplePrinter.feature("Bridge Detection");

        ExamplePrinter.graph(UNDIRECTED);

        ExamplePrinter.api(
                "graph.connectivity().bridges()"
        );

        ExamplePrinter.result(
                UNDIRECTED.connectivity().bridges()
        );
    }

    private static void articulationPoints() {

        ExamplePrinter.feature("Articulation Points");

        ExamplePrinter.graph(UNDIRECTED);

        ExamplePrinter.api(
                "graph.connectivity().articulationPoints()"
        );

        ExamplePrinter.result(
                UNDIRECTED.connectivity().articulationPoints()
        );
    }

    private static void biconnectedComponents() {

        ExamplePrinter.feature("Biconnected Components");

        ExamplePrinter.graph(UNDIRECTED);

        ExamplePrinter.api(
                "graph.connectivity().biconnectedComponents()"
        );

        ExamplePrinter.result(
                UNDIRECTED.connectivity().biconnectedComponents()
        );
    }

    // ==========================================================
    // Directed Graph Algorithms
    // ==========================================================

    private static void stronglyConnectedComponents() {

        ExamplePrinter.feature("Strongly Connected Components");

        ExamplePrinter.graph(DIRECTED);

        ExamplePrinter.api(
                "graph.connectivity().stronglyConnectedComponents()"
        );

        ExamplePrinter.result(
                DIRECTED.connectivity().stronglyConnectedComponents()
        );
    }

    public static void run() {

        ExamplePrinter.title("Connectivity Examples");

        connectedComponents();

        bridges();

        articulationPoints();

        biconnectedComponents();

        stronglyConnectedComponents();
    }
}
