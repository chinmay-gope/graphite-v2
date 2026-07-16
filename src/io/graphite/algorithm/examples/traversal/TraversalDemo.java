package io.graphite.algorithm.examples.traversal;

import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.algorithm.traversal.TraversalAlgorithm;
import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.builder.GraphBuilder;

public class TraversalDemo {

    static void main() {

        Graph graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .addEdge(2, 6)
                .build();

        TraversalAlgorithm bfs = new BFS();
        TraversalAlgorithm dfs = new DFS();

        GraphDemoPrinter.printHeader("Breadth First Search", graph);
        traversalAlgorithm(graph, bfs);

        GraphDemoPrinter.printHeader("Depth First Search", graph);
        traversalAlgorithm(graph, dfs);
    }

    private static void traversalAlgorithm(Graph graph, TraversalAlgorithm algorithm) {
        System.out.println(algorithm.traverse(graph, 0));
        System.out.println(algorithm.traverse(graph, 1));
        System.out.println(algorithm.traverse(graph, 2));
        System.out.println(algorithm.traverse(graph, 3));
        System.out.println(algorithm.traverse(graph, 4));
        System.out.println(algorithm.traverse(graph, 5));
        System.out.println(algorithm.traverse(graph, 6));
        System.out.println();
    }
}
