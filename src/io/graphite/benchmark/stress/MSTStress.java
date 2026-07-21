package io.graphite.benchmark.stress;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class MSTStress {
    private MSTStress() {
    }

    private static void stressPrim() {
        Prim prim = Prim.INSTANCE;

        StressRunner.run(
                "Prim Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetGenerator::mstGraph,
                graph -> prim.findMST(graph, ThreadLocalRandom.current().nextInt(graph.getVertices()))
        );
        StressRunner.run(
                "Prim Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::treeGraph,
                graph -> prim.findMST(graph, ThreadLocalRandom.current().nextInt(graph.getVertices()))
        );
    }

    private static void stressKruskal() {
        Kruskal kruskal = Kruskal.INSTANCE;

        StressRunner.run(
                "Kruskal Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetGenerator::weightedGraph,
                kruskal::findMST
        );
        StressRunner.run(
                "Kruskal Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetGenerator::treeGraph,
                kruskal::findMST
        );
    }

    public static void run() {
        stressKruskal();
        stressPrim();
    }

    static void main(String[] args) {
        stressKruskal();
        stressPrim();
    }
}
