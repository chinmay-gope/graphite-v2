package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.algorithm.topology.DFSTopologicalSort;
import main.java.io.graphite.algorithm.topology.KahnTopologicalSort;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

public final class TopologyBenchmark extends AbstractBenchmark {

    private static final IGraph DAG =
            GraphPresetGenerator.dag(1000);

    private TopologyBenchmark() {
    }

    public static void run() {

        benchmark(
                "DFS Topological Sort",
                DAG,
                () -> DFSTopologicalSort.INSTANCE.sort(DAG)
        );

        benchmark(
                "Kahn Topological Sort",
                DAG,
                () -> KahnTopologicalSort.INSTANCE.sort(DAG)
        );
    }
}
