package io.graphite.benchmark.connectivity;

import io.graphite.algorithm.connectivity.*;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetFactory;

public class ConnectivityBenchmark {
    public static void stressBiConnected() {

        BiconnectedAlgorithm components = BiconnectedComponents.INSTANCE;

        StressRunner.run(
                "Biconnected Components Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::sparseGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::traversalGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::mstGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::denseGraph,
                components::findBiconnectedComponents
        );
    }

    public static void stressAP() {
        APAlgorithm finder = APFinder.INSTANCE;

        StressRunner.run(
                "ArticulationPoint Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::sparseGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::traversalGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::mstGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::denseGraph,
                finder::findArticulationPoints
        );
    }

    public static void stressBridges() {
        BridgeAlgorithm bridges = BridgeFinder.INSTANCE;

        StressRunner.run(
                "Bridge Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::sparseGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::traversalGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::mstGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::denseGraph,
                bridges::findBridges
        );
    }

    public static void stressSCCs() {

        SCCAlgorithm scc = Kosaraju.INSTANCE;

        StressRunner.run(
                "SCC Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::directedSparseGraph,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dag)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::dag,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::directedDenseGraph,
                scc::findSCCs
        );
    }
}
