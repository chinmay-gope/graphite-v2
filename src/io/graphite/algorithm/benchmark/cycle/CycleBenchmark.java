package io.graphite.algorithm.benchmark.cycle;

import io.graphite.algorithm.benchmark.StressConfig;
import io.graphite.algorithm.benchmark.StressRunner;
import io.graphite.algorithm.cycle.CycleDetectionAlgorithm;
import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.algorithm.cycle.UndirectedCycleDetector;
import io.graphite.algorithm.graph.GraphFactory;

public class CycleBenchmark {
    public static void stressCycleDetection() {

        CycleDetectionAlgorithm cycleDetector = new DirectedCycleDetector();

        StressRunner.run(
                "CycleDetection Stress Test (directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::weightedGraph,
                cycleDetector::hasCycle
        );

        cycleDetector = new UndirectedCycleDetector();
        StressRunner.run(
                "CycleDetection Stress Test (un-directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::directedGraph,
                cycleDetector::hasCycle
        );
    }
}
