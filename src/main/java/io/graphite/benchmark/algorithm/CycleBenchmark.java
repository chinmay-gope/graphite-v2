package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.algorithm.cycle.DirectedCycleDetector;
import main.java.io.graphite.algorithm.cycle.UndirectedCycleDetector;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

public final class CycleBenchmark extends AbstractBenchmark {

    private static final IGraph DIRECTED =
            GraphPresetGenerator.directedGraph(1000);

    private static final IGraph UNDIRECTED =
            GraphPresetGenerator.sparseGraph(1000);

    public static void run() {

        benchmark(
                "Directed Cycle Detection",
                DIRECTED,
                () -> DirectedCycleDetector.INSTANCE.hasCycle(DIRECTED)
        );

        benchmark(
                "Undirected Cycle Detection",
                UNDIRECTED,
                () -> UndirectedCycleDetector.INSTANCE.hasCycle(UNDIRECTED)
        );
    }
}
