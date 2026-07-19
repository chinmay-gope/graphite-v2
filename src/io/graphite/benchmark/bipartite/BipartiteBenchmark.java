package io.graphite.benchmark.bipartite;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.BipartiteAlgorithm;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.graph.GraphFactory;

public class BipartiteBenchmark {
    public static void stressBipartite() {
        BipartiteAlgorithm bipartite = new BFSBipartiteChecker();

        StressRunner.run(
                "Bipartite Stress Test (bfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::weightedGraph,
                bipartite::isBipartite
        );
        StressRunner.run(
                "Bipartite Stress Test (bfs - bipartiteGraph)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::bipartiteGraph,
                bipartite::isBipartite
        );

        bipartite = new DFSBipartiteChecker();
        StressRunner.run(
                "Bipartite Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::bipartiteGraph,
                bipartite::isBipartite
        );
        StressRunner.run(
                "Bipartite Stress Test (dfs - bipartiteGraph)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::bipartiteGraph,
                bipartite::isBipartite
        );

    }
}
