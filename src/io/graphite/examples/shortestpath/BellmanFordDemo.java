package io.graphite.examples.shortestpath;

import io.graphite.algorithm.shortestpath.BellmanFord;
import io.graphite.algorithm.shortestpath.ShortestPathAlgorithm;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.result.ShortestPathResult;
import io.graphite.util.GraphPrinter;

public class BellmanFordDemo {
    static void main() {
        IGraph graph = Graphs
                .directed()
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 5)
                .addEdge(1, 2, -2)
                .addEdge(2, 3, 3)
                .addEdge(3, 1, 1)
                .build();

        GraphDemoPrinter.printHeader("BellmanFord Shortest Path", graph);
        GraphPrinter.printEdges(graph);

        ShortestPathAlgorithm algorithm =  BellmanFord.INSTANCE;

        ShortestPathResult result = algorithm.shortestPath(graph, 0);
        System.out.println(result);

        try {
            IGraph negativeWeightCycle = Graphs
                    .directed()
                    .addEdge(0, 1, 1)
                    .addEdge(1, 2, -1)
                    .addEdge(2, 3, -1)
                    .addEdge(3, 1, -1)
                    .build();

            GraphDemoPrinter.printHeader("BellmanFord Shortest Path for negativeWeightCycle", negativeWeightCycle);
            GraphPrinter.printEdges(negativeWeightCycle);

            result = algorithm.shortestPath(negativeWeightCycle, 0);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
