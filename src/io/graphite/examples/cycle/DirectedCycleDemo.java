package io.graphite.examples.cycle;

import io.graphite.algorithm.cycle.CycleDetectionAlgorithm;
import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.graph.Graph;
import io.graphite.graph.IGraph;

public class DirectedCycleDemo {
    static void main() {
        CycleDetectionAlgorithm detector =
                new DirectedCycleDetector();
        IGraph noCycleGraph = Graphs
                .directed()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();

        GraphDemoPrinter.printHeader("Directed Cycle Detection", noCycleGraph);
        System.out.println(detector.hasCycle(noCycleGraph));

        IGraph cycleGraph = Graphs
                .directed()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        GraphDemoPrinter.printHeader("Directed Cycle Detection", cycleGraph);
        System.out.println(detector.hasCycle(cycleGraph));
    }
}
