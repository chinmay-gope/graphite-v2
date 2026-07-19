package io.graphite.examples.topology;

import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.util.GraphPrinter;

public class KahnTopologicalDemo {
    static void main() {
        IGraph graph = Graphs
                .directed()
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

        IGraph cyclic = Graphs
                .directed()
                .addEdge(1, 2)
                .addEdge(0, 1)
                .addEdge(2, 0)
                .build();

        GraphDemoPrinter.printHeader("Kahn Topological Sort With Cycle", cyclic);
        GraphPrinter.printEdges(cyclic);

        System.out.println(algorithm.sort(cyclic));

        try {
            IGraph undirected = Graphs
                    .undirected()
                    .build();
            GraphDemoPrinter.printHeader("Kahn Topological Sort Undirected", undirected);
            System.out.println(algorithm.sort(undirected));
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
