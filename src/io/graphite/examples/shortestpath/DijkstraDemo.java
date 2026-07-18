package io.graphite.examples.shortestpath;

import io.graphite.algorithm.shortestpath.Dijkstra;
import io.graphite.algorithm.shortestpath.ShortestPathAlgorithm;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.Graph;
import io.graphite.result.ShortestPathResult;
import io.graphite.util.GraphPrinter;

public class DijkstraDemo {
    static void main() {
        Graph graph = Graphs
                .directed()
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 2)
                .addEdge(1, 2, 5)
                .addEdge(1, 3, 10)
                .addEdge(2, 4, 3)
                .addEdge(4, 3, 4)
                .addEdge(3, 5, 11)
                .build();

        GraphDemoPrinter.printHeader("Dijkstra Shortest Path", graph);
        GraphPrinter.printEdges(graph);

        ShortestPathAlgorithm algorithm = new Dijkstra();

        ShortestPathResult result = algorithm.shortestPath(graph, 0);
        System.out.println(result);

        GraphDemoPrinter.printFooter();

        Graph unreachableVertex = Graphs
                .directed()
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 2)
                .addEdge(2, 4, 3)
                .addEdge(4, 3, 4)
                .build();

        GraphDemoPrinter.printHeader("Dijkstra Shortest Path for Unreachable Vertex", unreachableVertex);
        GraphPrinter.printEdges(unreachableVertex);

        result = algorithm.shortestPath(unreachableVertex, 0);
        System.out.println(result);

        try {
            Graph g = Graphs
                    .directed()
                    .addEdge(0, 2, -2)
                    .build();

            GraphDemoPrinter.printHeader("Dijkstra Shortest Path for Negative Weight", g);

            result = algorithm.shortestPath(g, 0);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
