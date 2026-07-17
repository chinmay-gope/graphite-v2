package io.graphite.benchmark.shortestpath;

import io.graphite.algorithm.shortestpath.*;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.graph.GraphFactory;

import static io.graphite.benchmark.StressRunner.randomSource;

public class ShortestPathBenchmark {
    public static void stressDijkstra() {
        ShortestPathAlgorithm dijkstra = new Dijkstra();

        StressRunner.run(
                "Dijkstra Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                graph -> dijkstra.shortestPath(graph, randomSource(graph))
        );
    }

    public static void stressBellmanFord() {
        ShortestPathAlgorithm bellmanFord = new BellmanFord();

        StressRunner.run(
                "BellmanFord Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                graph -> bellmanFord.shortestPath(graph, randomSource(graph))
        );
    }

    public static void stressTestFloydWarshall() {
        AllPairsShortestPathAlgorithm floydWarshall = new FloydWarshall();
        StressRunner.run(
                "FloydWarshall Stress Test",
                StressConfig.FLOYD_CONFIG,
                GraphFactory::denseWeightedGraph,
                floydWarshall::shortestPaths
        );
    }
}
