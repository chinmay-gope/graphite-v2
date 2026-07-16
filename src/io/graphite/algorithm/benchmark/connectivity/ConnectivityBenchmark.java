package io.graphite.algorithm.benchmark.connectivity;

import io.graphite.algorithm.benchmark.StressConfig;
import io.graphite.algorithm.benchmark.StressRunner;
import io.graphite.algorithm.connectivity.*;
import io.graphite.algorithm.connectivity.APAlgorithm;
import io.graphite.algorithm.connectivity.BiconnectedAlgorithm;
import io.graphite.algorithm.connectivity.BridgeAlgorithm;
import io.graphite.algorithm.graph.GraphFactory;

public class ConnectivityBenchmark {
    public static void stressBiConnected() {

        BiconnectedAlgorithm components = new BiconnectedComponents();

        StressRunner.run(
                "Biconnected Components Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::sparseGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::mstGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::denseGraph,
                components::findBiconnectedComponents
        );
    }

    public static void stressAP() {
        APAlgorithm finder = new APFinder();

        StressRunner.run(
                "ArticulationPoint Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::sparseGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::mstGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::denseGraph,
                finder::findArticulationPoints
        );
    }

    public static void stressBridges() {
        BridgeAlgorithm bridges = new BridgeFinder();

        StressRunner.run(
                "Bridge Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::sparseGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::mstGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::denseGraph,
                bridges::findBridges
        );
    }

    public static void stressSCCs() {

        SCCAlgorithm scc = new Kosaraju();

        StressRunner.run(
                "SCC Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::directedSparseGraph,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dag)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::directedDenseGraph,
                scc::findSCCs
        );
    }
}
