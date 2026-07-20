package io.graphite.benchmark.cycle;

import io.graphite.algorithm.cycle.CycleDetectionAlgorithm;
import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.algorithm.cycle.UndirectedCycleDetector;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.graph.GraphFactory;

public class CycleBenchmark {
    public static void stressCycleDetection() {

        CycleDetectionAlgorithm cycleDetector = DirectedCycleDetector.INSTANCE;

        StressRunner.run(
                "CycleDetection Stress Test (directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::weightedGraph,
                cycleDetector::hasCycle
        );

        cycleDetector = UndirectedCycleDetector.INSTANCE;
        StressRunner.run(
                "CycleDetection Stress Test (un-directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::directedGraph,
                cycleDetector::hasCycle
        );
    }
}
