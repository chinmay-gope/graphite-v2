package io.graphite.benchmark.stress;

import io.graphite.algorithm.connectivity.*;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetGenerator;

public class ConnectivityStress {

    private ConnectivityStress() {
    }

    private static void stressBiConnected() {

        BiconnectedAlgorithm components = BiconnectedComponents.INSTANCE;

        StressRunner.run(
                "Biconnected Components Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::sparseGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::traversalGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::mstGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (dense)",
                StressConfig.DENSE_CONFIG,
                GraphPresetGenerator::denseGraph,
                components::findBiconnectedComponents
        );
    }

    private static void stressAP() {
        APAlgorithm finder = APFinder.INSTANCE;

        StressRunner.run(
                "ArticulationPoint Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::sparseGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::traversalGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::mstGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (dense)",
                StressConfig.DENSE_CONFIG,
                GraphPresetGenerator::denseGraph,
                finder::findArticulationPoints
        );
    }

    private static void stressBridges() {
        BridgeAlgorithm bridges = BridgeFinder.INSTANCE;

        StressRunner.run(
                "Bridge Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::sparseGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::traversalGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::mstGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (dense)",
                StressConfig.DENSE_CONFIG,
                GraphPresetGenerator::denseGraph,
                bridges::findBridges
        );
    }

    private static void stressSCCs() {

        SCCAlgorithm scc = Kosaraju.INSTANCE;

        StressRunner.run(
                "SCC Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::directedSparseGraph,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dag)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::dag,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dense)",
                StressConfig.DENSE_CONFIG,
                GraphPresetGenerator::directedDenseGraph,
                scc::findSCCs
        );
    }

    public static void run() {
        stressBiConnected();
        stressAP();
        stressBridges();
        stressSCCs();
    }

    static void main(String[] args) {
        run();
    }
}
