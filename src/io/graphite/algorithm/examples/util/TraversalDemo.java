package io.graphite.algorithm.examples.util;

import io.graphite.algorithm.builder.Graphs;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;

public final class TraversalDemo {

    private static final IGraph GRAPH =
            Graphs
                    .undirected(8)
                    .addEdge(0, 1)
                    .addEdge(0, 2)
                    .addEdge(1, 3)
                    .addEdge(1, 4)
                    .addEdge(2, 5)
                    .addEdge(4, 6)
                    .addEdge(5, 7)
                    .build();

    private TraversalDemo() {
        throw new AssertionError("Utility class");
    }

    static void main() {
        DemoPrinter.printHeader(
                "Traversal Algorithms",
                GRAPH
        );

        DemoUtils.run(
                "Graph",
                () -> DemoUtils.printGraph(GRAPH)
        );

        DemoUtils.run(
                "Breadth First Search",
                () -> DemoUtils.printTraversalsFromAllVertices(
                        GRAPH,
                        new BFS())
        );

        DemoUtils.run(
                "Depth First Search",
                () -> DemoUtils.printTraversalsFromAllVertices(
                        GRAPH,
                        new DFS())
        );
    }
}
