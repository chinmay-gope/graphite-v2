package io.graphite.benchmark.topology;

import io.graphite.algorithm.topology.DFSTopologicalSort;
import io.graphite.algorithm.topology.KahnTopologicalSort;
import io.graphite.algorithm.topology.TopologicalAlgorithm;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.graph.GraphFactory;

public class TopologyBenchmark {
    public static void stressTestTopo() {
        TopologicalAlgorithm topo =  DFSTopologicalSort.INSTANCE;
        StressRunner.run(
                "Topological Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                topo::sort
        );

        topo = KahnTopologicalSort.INSTANCE;
        StressRunner.run(
                "Topological Stress Test (Kahn)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                topo::sort
        );

    }
}
