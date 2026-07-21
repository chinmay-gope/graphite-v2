package io.graphite.examples.topology;

import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.util.GraphPrinter;

public class TopologicalDemo {
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

        GraphDemoPrinter.printHeader("DFS Topological Sort", graph);
        GraphPrinter.print(graph);

        DFSTopologicalSort algorithm = DFSTopologicalSort.INSTANCE;
        System.out.println(algorithm.sort(graph));

        try {
            graph = Graphs
                    .directed()
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
