package io.graphite.algorithm.benchmark.mst;

import io.graphite.algorithm.benchmark.StressConfig;
import io.graphite.algorithm.benchmark.StressRunner;
import io.graphite.algorithm.mst.Kruskal;
import io.graphite.algorithm.mst.MSTAlgorithm;
import io.graphite.algorithm.mst.Prim;
import io.graphite.algorithm.graph.GraphFactory;

import static io.graphite.algorithm.benchmark.StressRunner.randomSource;

public class MSTBenchmark {
    public static void stressPrim() {
        MSTAlgorithm prim = new Prim();

        StressRunner.run(
                "Prim Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::mstGraph,
                graph -> prim.findMST(graph, randomSource(graph))
        );
        StressRunner.run(
                "Prim Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::treeGraph,
                graph -> prim.findMST(graph, randomSource(graph))
        );
    }

    public static void stressKruskal() {
        MSTAlgorithm kruskal = new Kruskal();

        StressRunner.run(
                "Kruskal Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                graph -> kruskal.findMST(graph, randomSource(graph))
        );
        StressRunner.run(
                "Kruskal Stress Test - (tree)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::treeGraph,
                graph -> kruskal.findMST(graph, randomSource(graph))
        );
    }
}
