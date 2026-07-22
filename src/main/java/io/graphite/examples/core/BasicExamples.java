package io.graphite.examples.core;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;

public final class BasicExamples {

    private static final IGraph GRAPH =
            Graphs.undirected()
                    .addEdge(0, 1)
                    .addEdge(0, 2)
                    .addEdge(1, 3)
                    .addEdge(2, 4)
                    .addEdge(3, 4)
                    .build();

    private BasicExamples() {
    }

    private static void createGraph() {

        ExamplePrinter.feature("Creating a Graph");

        ExamplePrinter.api("""
                Graphs.undirected()
                      .addEdge(0,1)
                      .addEdge(0,2)
                      .addEdge(1,3)
                      .addEdge(2,4)
                      .addEdge(3,4)
                      .build()
                """);

        ExamplePrinter.graph(GRAPH);
    }

    private static void traversal() {

        ExamplePrinter.feature("Breadth First Search");

        ExamplePrinter.api(
                "graph.traversal().bfs(0)"
        );

        ExamplePrinter.result(
                GRAPH.traversal().bfs(0)
        );
    }

    private static void shortestPath() {

        ExamplePrinter.feature("Shortest Path");

        ExamplePrinter.api(
                "graph.shortestPath().dijkstra(0)"
        );

        ExamplePrinter.result(
                GRAPH.shortestPath().dijkstra(0)
        );
    }

    private static void minimumSpanningTree() {

        ExamplePrinter.feature("Minimum Spanning Tree");

        ExamplePrinter.api(
                "graph.mst().prim(0)"
        );

        ExamplePrinter.result(
                GRAPH.mst().prim(0)
        );
    }

    public static void run() {

        ExamplePrinter.title("Basic Examples");

        traversal();

        createGraph();

        shortestPath();

        minimumSpanningTree();
    }
}
