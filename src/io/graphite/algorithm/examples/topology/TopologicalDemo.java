package io.graphite.algorithm.examples.topology;

import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.algorithm.exception.GraphException;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.builder.GraphBuilder;
import io.graphite.algorithm.util.GraphPrinter;

public class TopologicalDemo {
    static void main() {
        Graph graph = GraphBuilder
                .directed(6)
                .addEdge(5, 2)
                .addEdge(5, 0)
                .addEdge(4, 0)
                .addEdge(4, 1)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        GraphDemoPrinter.printHeader("DFS Topological Sort", graph);
        GraphPrinter.print(graph);

        DFSTopologicalSort algorithm = new DFSTopologicalSort();
        System.out.println(algorithm.sort(graph));

        try {
            graph = GraphBuilder
                    .directed(3)
                    .addEdge(0, 1)
                    .addEdge(1, 2)
                    .addEdge(2, 0)
                    .build();

            GraphDemoPrinter.printHeader("DFS Topological Sort With Cycle", graph);
            System.out.println(algorithm.sort(graph));
            GraphPrinter.print(graph);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
