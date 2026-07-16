package io.graphite.algorithm.benchmark.topology;

import io.graphite.algorithm.benchmark.StressConfig;
import io.graphite.algorithm.benchmark.StressRunner;
import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.algorithm.topology.TopologicalAlgorithm;
import io.graphite.algorithm.graph.GraphFactory;

public class TopologyBenchmark {
    public static void stressTestTopo() {
        TopologicalAlgorithm topo = new DFSTopologicalSort();
        StressRunner.run(
                "Topological Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                topo::sort
        );

        topo = new KahnTopologicalSort();
        StressRunner.run(
                "Topological Stress Test (Kahn)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                topo::sort
        );

    }
}
