package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

public final class MSTBenchmark extends AbstractBenchmark {

    private static final IGraph GRAPH =
            GraphPresetGenerator.mstGraph(1000);

    public static void run() {

        benchmark(
                "Prim MST",
                GRAPH,
                () -> GRAPH.mst().prim(0)
        );

        benchmark(
                "Kruskal MST",
                GRAPH,
                () -> GRAPH.mst().kruskal()
        );
    }
}
