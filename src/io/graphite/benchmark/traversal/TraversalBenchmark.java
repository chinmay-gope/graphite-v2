package io.graphite.benchmark.traversal;

import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.algorithm.traversal.TraversalAlgorithm;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetFactory;

import static io.graphite.benchmark.StressRunner.randomSource;


public class TraversalBenchmark {
    public static void stressBFS() {

        TraversalAlgorithm bfs = BFS.INSTANCE;

        StressRunner.run(
                "BFS Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::traversalGraph,
                graph -> bfs.traverse(graph, randomSource(graph))
        );
    }

    public static void stressDFS() {

        TraversalAlgorithm dfs = DFS.INSTANCE;

        StressRunner.run(
                "DFS Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::traversalGraph,
                graph -> dfs.traverse(graph, randomSource(graph))
        );
        StressRunner.run(
                "DFS Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::treeGraph,
                graph -> dfs.traverse(graph, randomSource(graph))
        );
    }
}
