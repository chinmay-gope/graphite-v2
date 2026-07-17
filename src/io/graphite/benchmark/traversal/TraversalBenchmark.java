package io.graphite.benchmark.traversal;

import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.algorithm.traversal.TraversalAlgorithm;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.graph.GraphFactory;

import static io.graphite.benchmark.StressRunner.randomSource;


public class TraversalBenchmark {
    public static void stressBFS() {

        TraversalAlgorithm bfs = new BFS();

        StressRunner.run(
                "BFS Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                graph -> bfs.traverse(graph, randomSource(graph))
        );
    }

    public static void stressDFS() {

        TraversalAlgorithm dfs = new DFS();

        StressRunner.run(
                "DFS Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                graph -> dfs.traverse(graph, randomSource(graph))
        );
        StressRunner.run(
                "DFS Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::treeGraph,
                graph -> dfs.traverse(graph, randomSource(graph))
        );
    }
}
