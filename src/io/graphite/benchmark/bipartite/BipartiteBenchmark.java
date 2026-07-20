package io.graphite.benchmark.bipartite;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.BipartiteAlgorithm;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetFactory;

public class BipartiteBenchmark {
    public static void stressBipartite() {
        BipartiteAlgorithm bipartite = BFSBipartiteChecker.INSTANCE;

        StressRunner.run(
                "Bipartite Stress Test (bfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::weightedGraph,
                bipartite::isBipartite
        );
        StressRunner.run(
                "Bipartite Stress Test (bfs - bipartiteGraph)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::bipartiteGraph,
                bipartite::isBipartite
        );

        bipartite = DFSBipartiteChecker.INSTANCE;
        StressRunner.run(
                "Bipartite Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::bipartiteGraph,
                bipartite::isBipartite
        );
        StressRunner.run(
                "Bipartite Stress Test (dfs - bipartiteGraph)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::bipartiteGraph,
                bipartite::isBipartite
        );

    }
}
