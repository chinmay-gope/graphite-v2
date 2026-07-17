package io.graphite.algorithm.examples.topology;

import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.algorithm.exception.GraphException;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.builder.Graphs;
import io.graphite.algorithm.util.GraphPrinter;

public class KahnTopologicalDemo {
    static void main() {
        Graph graph = Graphs
                .directed(6)
                .addEdge(5, 2)
                .addEdge(5, 0)
                .addEdge(4, 0)
                .addEdge(4, 1)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        GraphDemoPrinter.printHeader("Kahn Topological Sort", graph);
        GraphPrinter.printEdges(graph);

        KahnTopologicalSort algorithm = new KahnTopologicalSort();
        System.out.println(algorithm.sort(graph));

        Graph cyclic = Graphs
                .directed(3)
                .addEdge(1, 2)
                .addEdge(0, 1)
                .addEdge(2, 0)
                .build();

        GraphDemoPrinter.printHeader("Kahn Topological Sort With Cycle", cyclic);
        GraphPrinter.printEdges(cyclic);

        System.out.println(algorithm.sort(cyclic));

        try {
            Graph undirected = Graphs
                    .undirected(3)
                    .build();
            GraphDemoPrinter.printHeader("Kahn Topological Sort Undirected", undirected);
            System.out.println(algorithm.sort(undirected));
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
