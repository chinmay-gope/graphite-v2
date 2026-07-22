package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

public final class TraversalBenchmark extends AbstractBenchmark {

    private static final IGraph GRAPH =
            GraphPresetGenerator.traversalGraph(1000);

    private TraversalBenchmark() {
    }

    private static void benchmarkBFS() {
        benchmark(
                "BFS",
                GRAPH,
                () -> GRAPH.traversal().bfs(0)
        );
    }

    private static void benchmarkDFS() {
        benchmark(
                "DFS",
                GRAPH,
                () -> GRAPH.traversal().dfs(0)
        );
    }

    public static void run() {
        benchmarkBFS();
        benchmarkDFS();
    }
}
