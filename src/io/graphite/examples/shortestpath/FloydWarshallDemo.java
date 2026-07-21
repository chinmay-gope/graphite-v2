package io.graphite.examples.shortestpath;

import io.graphite.algorithm.shortestpath.AllPairsShortestPathAlgorithm;
import io.graphite.algorithm.shortestpath.FloydWarshall;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.result.AllPairsShortestPathResult;
import io.graphite.util.GraphPrinter;

public class FloydWarshallDemo {
    static void main() {
        IGraph graph = Graphs
                .directed()
                .addEdge(0, 1, 5)
                .addEdge(0, 3, 10)
                .addEdge(1, 2, 3)
                .addEdge(2, 3, 1)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Algorithm", graph);
        GraphPrinter.print(graph);

        AllPairsShortestPathAlgorithm algorithm = FloydWarshall.INSTANCE;
        AllPairsShortestPathResult result = algorithm.shortestPaths(graph);
        System.out.println(result);

        graph = Graphs
                .undirected()
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 1)
                .addEdge(1, 2, 2)
                .addEdge(1, 3, 5)
                .addEdge(2, 3, 8)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Algorithm Undirected Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);


        graph = Graphs
                .directed()
                .addEdge(0, 1, 3)
                .addEdge(0, 2, 8)
                .addEdge(0, 4, -4)
                .addEdge(1, 3, 1)
                .addEdge(1, 4, 7)
                .addEdge(2, 1, 4)
                .addEdge(3, 0, 2)
                .addEdge(3, 2, -5)
                .addEdge(4, 3, 6)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Algorithm Negative Edges (No Negative Cycle)", graph);
        GraphPrinter.print(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 2)
                .addEdge(1, 2, 4)
                .addEdge(3, 4, 1)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Disconnected Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 10)
                .addEdge(0, 2, 3)
                .addEdge(2, 1, 1)
                .addEdge(1, 3, 2)
                .addEdge(2, 3, 8)
                .addEdge(3, 4, 7)
                .addEdge(2, 4, 20)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Multiple Alternative Paths", graph);
        GraphPrinter.print(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 2)
                .addEdge(0, 2, 9)
                .addEdge(0, 3, 8)
                .addEdge(0, 4, 5)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 3)
                .addEdge(1, 4, 7)
                .addEdge(2, 3, 2)
                .addEdge(2, 4, 4)
                .addEdge(3, 4, 1)
                .build();
        GraphDemoPrinter.printHeader(
                "FloydWarshall Dense Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 1, 1)
                .addEdge(1, 2, 2)
                .addEdge(2, 3, 3)
                .addEdge(3, 4, 4)
                .addEdge(4, 5, 5)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Multiple Long Chain", graph);
        GraphPrinter.print(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);

        graph = Graphs
                .directed()
                .addEdge(0, 0, 5)
                .addEdge(0, 1, 2)
                .addEdge(1, 2, 3)
                .build();
        GraphDemoPrinter.printHeader("FloydWarshall Self Loop", graph);
        GraphPrinter.printEdges(graph);
        result = algorithm.shortestPaths(graph);
        System.out.println(result);
        try {
            graph = Graphs
                    .directed()
                    .addEdge(0, 1, 1)
                    .addEdge(1, 2, -2)
                    .addEdge(2, 0, -2)
                    .build();
            GraphDemoPrinter.printHeader("FloydWarshall Negative Cycle", graph);
            GraphPrinter.print(graph);
            result = algorithm.shortestPaths(graph);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
