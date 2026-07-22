package io.graphite.benchmark.stress;

import io.graphite.algorithm.traversal.BFS;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.algorithm.traversal.TraversalAlgorithm;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetGenerator;

import static io.graphite.benchmark.StressRunner.randomSource;


public class TraversalStress {

    private TraversalStress() {
    }

    private static void stressBFS() {

        TraversalAlgorithm bfs = BFS.INSTANCE;

        StressRunner.run("BFS Stress Test", StressConfig.DEFAULT_CONFIG, GraphPresetGenerator::traversalGraph, graph -> bfs.traverse(graph, randomSource(graph)));
    }

    private static void stressDFS() {

        TraversalAlgorithm dfs = DFS.INSTANCE;

        StressRunner.run("DFS Stress Test", StressConfig.DEFAULT_CONFIG, GraphPresetGenerator::traversalGraph, graph -> dfs.traverse(graph, randomSource(graph)));
        StressRunner.run("DFS Stress Test - (tree)", StressConfig.DEFAULT_CONFIG, GraphPresetGenerator::treeGraph, graph -> dfs.traverse(graph, randomSource(graph)));
    }

    public static void run() {
        stressBFS();
        stressDFS();
    }

    static void main(String[] args) {
        stressBFS();
        stressDFS();
    }
}
