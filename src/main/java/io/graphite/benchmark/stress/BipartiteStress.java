package io.graphite.benchmark.stress;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.BipartiteAlgorithm;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetGenerator;

public class BipartiteStress {

    private BipartiteStress() {
    }

    private static void stressBipartite() {
        BipartiteAlgorithm bipartite = BFSBipartiteChecker.INSTANCE;

        StressRunner.run(
                "Bipartite Stress Test (bfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::weightedGraph,
                bipartite::isBipartite
        );
        StressRunner.run(
                "Bipartite Stress Test (bfs - bipartiteGraph)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::bipartiteGraph,
                bipartite::isBipartite
        );

        bipartite = DFSBipartiteChecker.INSTANCE;
        StressRunner.run(
                "Bipartite Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::bipartiteGraph,
                bipartite::isBipartite
        );
        StressRunner.run(
                "Bipartite Stress Test (dfs - bipartiteGraph)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::bipartiteGraph,
                bipartite::isBipartite
        );

    }

    public static void run() {
        stressBipartite();
    }

    static void main(String[] args) {
        stressBipartite();
    }
}
