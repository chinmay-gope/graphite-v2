package io.graphite.examples.core;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;

public final class BuilderExamples {

    private BuilderExamples() {
    }

    private static void undirectedGraph() {

        IGraph graph = Graphs.undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .build();

        ExamplePrinter.feature("Undirected Graph");

        ExamplePrinter.api("""
                Graphs.undirected()
                      .addEdge(0,1)
                      .addEdge(1,2)
                      .addEdge(2,3)
                      .build()
                """);

        ExamplePrinter.graph(graph);
    }

    private static void directedGraph() {

        IGraph graph = Graphs.directed()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();

        ExamplePrinter.feature("Directed Graph");

        ExamplePrinter.api("""
                Graphs.directed()
                      .addEdge(0,1)
                      .addEdge(1,2)
                      .addEdge(2,0)
                      .build()
                """);

        ExamplePrinter.graph(graph);
    }

    private static void weightedGraph() {

        IGraph graph = Graphs.undirected()
                .weighted(true)
                .addEdge(0, 1, 4)
                .addEdge(1, 2, 2)
                .addEdge(0, 2, 8)
                .build();

        ExamplePrinter.feature("Weighted Graph");

        ExamplePrinter.api("""
                Graphs.undirected()
                      .weighted(true)
                      .addEdge(0,1,4)
                      .addEdge(1,2,2)
                      .addEdge(0,2,8)
                      .build()
                """);

        ExamplePrinter.graph(graph);
    }

    private static void immutableGraph() {

        IGraph graph = Graphs.undirected()
                .immutable(true)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .build();

        ExamplePrinter.feature("Immutable Graph");

        ExamplePrinter.api("""
                Graphs.undirected()
                      .immutable(true)
                      .addEdge(0,1)
                      .addEdge(1,2)
                      .build()
                """);

        ExamplePrinter.graph(graph);
    }

    public static void run() {

        ExamplePrinter.title("Builder Examples");

        undirectedGraph();

        directedGraph();

        weightedGraph();

        immutableGraph();
    }
}
