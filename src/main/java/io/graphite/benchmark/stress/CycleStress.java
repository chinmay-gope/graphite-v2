package io.graphite.benchmark.stress;

import io.graphite.algorithm.cycle.CycleDetectionAlgorithm;
import io.graphite.algorithm.cycle.DirectedCycleDetector;
import io.graphite.algorithm.cycle.UndirectedCycleDetector;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetGenerator;

public class CycleStress {

    private CycleStress() {
    }

    private static void stressCycleDetection() {

        CycleDetectionAlgorithm cycleDetector = DirectedCycleDetector.INSTANCE;

        StressRunner.run(
                "CycleDetection Stress Test (directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::weightedGraph,
                cycleDetector::hasCycle
        );

        cycleDetector = UndirectedCycleDetector.INSTANCE;
        StressRunner.run(
                "CycleDetection Stress Test (un-directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::directedGraph,
                cycleDetector::hasCycle
        );
    }

    public static void run() {
        stressCycleDetection();
    }

    static void main(String[] args) {
        stressCycleDetection();
    }
}
