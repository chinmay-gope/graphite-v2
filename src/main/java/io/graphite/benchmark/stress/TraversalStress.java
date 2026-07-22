package main.java.io.graphite.benchmark.stress;

import main.java.io.graphite.algorithm.traversal.BFS;
import main.java.io.graphite.algorithm.traversal.DFS;
import main.java.io.graphite.algorithm.traversal.TraversalAlgorithm;
import main.java.io.graphite.benchmark.StressConfig;
import main.java.io.graphite.benchmark.StressRunner;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;

import static main.java.io.graphite.benchmark.StressRunner.randomSource;


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
