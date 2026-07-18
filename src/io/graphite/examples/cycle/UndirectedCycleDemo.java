package io.graphite.examples.cycle;

import io.graphite.algorithm.cycle.CycleDetectionAlgorithm;
import io.graphite.algorithm.cycle.UndirectedCycleDetector;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.graph.Graph;

public class UndirectedCycleDemo {
    static void main() {
        CycleDetectionAlgorithm detector =
                new UndirectedCycleDetector();
        Graph noCycleGraph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();

        GraphDemoPrinter.printHeader("Undirected Cycle Detection", noCycleGraph);
        System.out.println(detector.hasCycle(noCycleGraph));

        Graph cycleGraph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        GraphDemoPrinter.printHeader("Undirected Cycle Detection", cycleGraph);
        System.out.println(detector.hasCycle(cycleGraph));
    }
}
