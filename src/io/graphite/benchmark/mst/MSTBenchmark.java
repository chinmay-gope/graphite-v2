package io.graphite.benchmark.mst;

import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.Prim;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.graph.GraphFactory;

import java.util.concurrent.ThreadLocalRandom;

public class MSTBenchmark {
    public static void stressPrim() {
        Prim prim = Prim.INSTANCE;

        StressRunner.run(
                "Prim Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::mstGraph,
                graph -> prim.findMST(graph, ThreadLocalRandom.current().nextInt(graph.getVertices()))
        );
        StressRunner.run(
                "Prim Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::treeGraph,
                graph -> prim.findMST(graph, ThreadLocalRandom.current().nextInt(graph.getVertices()))
        );
    }

    public static void stressKruskal() {
        Kruskal kruskal =  Kruskal.INSTANCE;

        StressRunner.run(
                "Kruskal Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                kruskal::findMST
        );
        StressRunner.run(
                "Kruskal Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::treeGraph,
                kruskal::findMST
        );
    }
}
