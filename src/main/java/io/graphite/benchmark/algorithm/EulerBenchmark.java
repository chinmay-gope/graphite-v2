package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.algorithm.euler.Hierholzer;
import main.java.io.graphite.generator.example.GraphExampleGenerator;
import main.java.io.graphite.graph.IGraph;

public final class EulerBenchmark extends AbstractBenchmark {

    private static final IGraph PATH =
            GraphExampleGenerator.eulerPathGraph(1000);

    private static final IGraph CIRCUIT =
            GraphExampleGenerator.eulerCircuitGraph(1000);

    private EulerBenchmark() {
    }

    public static void run() {

        benchmark(
                "Euler Path",
                PATH,
                () -> Hierholzer.INSTANCE.findEulerPath(PATH)
        );

        benchmark(
                "Euler Circuit",
                CIRCUIT,
                () -> Hierholzer.INSTANCE.findEulerCircuit(CIRCUIT)
        );
    }
}
