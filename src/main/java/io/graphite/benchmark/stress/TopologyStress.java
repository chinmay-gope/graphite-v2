package main.java.io.graphite.benchmark.stress;

import main.java.io.graphite.algorithm.topology.DFSTopologicalSort;
import main.java.io.graphite.algorithm.topology.KahnTopologicalSort;
import main.java.io.graphite.algorithm.topology.TopologicalAlgorithm;
import main.java.io.graphite.benchmark.StressConfig;
import main.java.io.graphite.benchmark.StressRunner;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;

public class TopologyStress {

    private TopologyStress() {
    }

    private static void stressTestTopo() {
        TopologicalAlgorithm topo = DFSTopologicalSort.INSTANCE;
        StressRunner.run(
                "Topological Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::dag,
                topo::sort
        );

        topo = KahnTopologicalSort.INSTANCE;
        StressRunner.run(
                "Topological Stress Test (Kahn)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::dag,
                topo::sort
        );

    }

    public static void run() {
        stressTestTopo();
    }

    static void main(String[] args) {
        stressTestTopo();
    }
}
