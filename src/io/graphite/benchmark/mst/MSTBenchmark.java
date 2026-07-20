package io.graphite.benchmark.mst;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.generator.preset.GraphPresetFactory;

import java.util.concurrent.ThreadLocalRandom;

public class MSTBenchmark {
    public static void stressPrim() {
        Prim prim = Prim.INSTANCE;

        StressRunner.run(
                "Prim Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::mstGraph,
                graph -> prim.findMST(graph, ThreadLocalRandom.current().nextInt(graph.getVertices()))
        );
        StressRunner.run(
                "Prim Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::treeGraph,
                graph -> prim.findMST(graph, ThreadLocalRandom.current().nextInt(graph.getVertices()))
        );
    }

    public static void stressKruskal() {
        Kruskal kruskal =  Kruskal.INSTANCE;

        StressRunner.run(
                "Kruskal Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphPresetFactory::weightedGraph,
                kruskal::findMST
        );
        StressRunner.run(
                "Kruskal Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphPresetFactory::treeGraph,
                kruskal::findMST
        );
    }
}
