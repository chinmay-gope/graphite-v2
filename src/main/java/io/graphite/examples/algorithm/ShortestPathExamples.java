package main.java.io.graphite.examples.algorithm;

import main.java.io.graphite.builder.Graphs;
import main.java.io.graphite.examples.ExamplePrinter;
import main.java.io.graphite.graph.IGraph;

public final class ShortestPathExamples {

    private static final IGraph GRAPH =
            Graphs.undirected()
                    .weighted(true)
                    .addEdge(0, 1, 4)
                    .addEdge(0, 2, 1)
                    .addEdge(2, 1, 2)
                    .addEdge(1, 3, 1)
                    .addEdge(2, 3, 5)
                    .addEdge(3, 4, 3)
                    .build();

    private ShortestPathExamples() {
    }

    private static void dijkstra() {

        ExamplePrinter.feature("Dijkstra");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.shortestPath().dijkstra(0)"
        );

        ExamplePrinter.result(
                GRAPH.shortestPath().dijkstra(0)
        );
    }

    private static void bellmanFord() {

        ExamplePrinter.feature("Bellman-Ford");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.shortestPath().bellmanFord(0)"
        );

        ExamplePrinter.result(
                GRAPH.shortestPath().bellmanFord(0)
        );
    }

    private static void floydWarshall() {

        ExamplePrinter.feature("Floyd-Warshall");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.shortestPath().floydWarshall()"
        );

        ExamplePrinter.result(
                GRAPH.shortestPath().floydWarshall()
        );
    }

    public static void run() {

        ExamplePrinter.title("Shortest Path Examples");

        dijkstra();

        bellmanFord();

        floydWarshall();
    }
}
