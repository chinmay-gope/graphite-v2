package main.java.io.graphite.benchmark.stress;

import main.java.graphite.algorithm.shortestpath.*;
import main.java.io.graphite.algorithm.shortestpath.*;
import main.java.io.graphite.benchmark.StressConfig;
import main.java.io.graphite.benchmark.StressRunner;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;

import static main.java.io.graphite.benchmark.StressRunner.randomSource;

public class ShortestPathStress {

    private ShortestPathStress() {
    }

    private static void stressDijkstra() {
        ShortestPathAlgorithm dijkstra = Dijkstra.INSTANCE;

        StressRunner.run(
                "Dijkstra Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetGenerator::weightedGraph,
                graph -> dijkstra.shortestPath(graph, randomSource(graph))
        );
    }

    private static void stressBellmanFord() {
        ShortestPathAlgorithm bellmanFord = BellmanFord.INSTANCE;

        StressRunner.run(
                "BellmanFord Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetGenerator::weightedGraph,
                graph -> bellmanFord.shortestPath(graph, randomSource(graph))
        );
    }

    private static void stressTestFloydWarshall() {
        AllPairsShortestPathAlgorithm floydWarshall = FloydWarshall.INSTANCE;
        StressRunner.run(
                "FloydWarshall Stress Test",
                StressConfig.FLOYD_CONFIG,
                GraphPresetGenerator::denseWeightedGraph,
                floydWarshall::shortestPaths
        );
    }

    public static void run() {
        stressDijkstra();
        stressBellmanFord();
        stressTestFloydWarshall();
    }

    static void main(String[] args) {
        stressDijkstra();
        stressBellmanFord();
        stressTestFloydWarshall();
    }
}
