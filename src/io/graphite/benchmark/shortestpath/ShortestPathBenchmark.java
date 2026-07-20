package io.graphite.benchmark.shortestpath;

import io.graphite.algorithm.shortestpath.*;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetFactory;

import static io.graphite.benchmark.StressRunner.randomSource;

public class ShortestPathBenchmark {
    public static void stressDijkstra() {
        ShortestPathAlgorithm dijkstra = Dijkstra.INSTANCE;

        StressRunner.run(
                "Dijkstra Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::weightedGraph,
                graph -> dijkstra.shortestPath(graph, randomSource(graph))
        );
    }

    public static void stressBellmanFord() {
        ShortestPathAlgorithm bellmanFord = BellmanFord.INSTANCE;

        StressRunner.run(
                "BellmanFord Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::weightedGraph,
                graph -> bellmanFord.shortestPath(graph, randomSource(graph))
        );
    }

    public static void stressTestFloydWarshall() {
        AllPairsShortestPathAlgorithm floydWarshall = FloydWarshall.INSTANCE;
        StressRunner.run(
                "FloydWarshall Stress Test",
                StressConfig.FLOYD_CONFIG,
                GraphPresetFactory::denseWeightedGraph,
                floydWarshall::shortestPaths
        );
    }
}
