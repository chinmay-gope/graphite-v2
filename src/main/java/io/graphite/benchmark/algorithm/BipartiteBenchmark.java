package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import main.java.io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

public final class BipartiteBenchmark extends AbstractBenchmark {

    private static final IGraph GRAPH =
            GraphPresetGenerator.bipartiteGraph(1000);

    private BipartiteBenchmark() {
    }

    public static void run() {

        benchmark(
                "BFS Bipartite Check",
                GRAPH,
                () -> BFSBipartiteChecker.INSTANCE.isBipartite(GRAPH)
        );

        benchmark(
                "DFS Bipartite Check",
                GRAPH,
                () -> DFSBipartiteChecker.INSTANCE.isBipartite(GRAPH)
        );
    }
}
