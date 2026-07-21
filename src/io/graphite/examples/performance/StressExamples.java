package io.graphite.examples.performance;

import io.graphite.benchmark.stress.*;
import io.graphite.examples.ExamplePrinter;

public final class StressExamples {

    private StressExamples() {
    }

    private static void traversalStress() {

        ExamplePrinter.feature("Traversal Stress Test");

        ExamplePrinter.api("""
                StressRunner.run(
                    "BFS Stress Test",
                    StressConfig.DEFAULT_CONFIG,
                    GraphPresetGenerator::traversalGraph,
                    graph -> graph.traversal().bfs(0)
                )
                """);

        TraversalStress.run();
    }

    private static void shortestPathStress() {

        ExamplePrinter.feature("Shortest Path Stress Test");

        ShortestPathStress.run();
    }

    private static void mstStress() {

        ExamplePrinter.feature("Minimum Spanning Tree Stress Test");

        MSTStress.run();
    }

    private static void cycleStress() {

        ExamplePrinter.feature("Cycle Detection Stress Test");

        CycleStress.run();
    }

    private static void topologyStress() {

        ExamplePrinter.feature("Topological Sorting Stress Test");

        TopologyStress.run();
    }

    private static void connectivityStress() {

        ExamplePrinter.feature("Connectivity Stress Test");

        ConnectivityStress.run();
    }

    public static void run() {

        ExamplePrinter.title("Stress Testing Examples");

        traversalStress();

        shortestPathStress();

        mstStress();

        cycleStress();

        topologyStress();

        connectivityStress();
    }
}
