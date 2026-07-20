package io.graphite.benchmark.euler;

import io.graphite.algorithm.euler.EulerAlgorithm;
import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.benchmark.StressConfig;
import io.graphite.benchmark.StressRunner;
import io.graphite.exception.algorithm.GraphCycleException;
import io.graphite.exception.graph.GraphDisconnectedException;
import io.graphite.graph.GraphFactory;
import io.graphite.result.EulerResult;
import io.graphite.validation.EulerValidator;

public class EulerBenchmark {
    public static void stressEulerPath() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Euler Path Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::eulerPathGraph,
                graph -> {

                    EulerResult result =
                            algorithm.findEulerPath(graph);

                    EulerValidator.validate(graph, result);
                }
        );
    }

    public static void stressEulerCircuit() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Euler Circuit Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::eulerCircuitGraph,
                graph -> {

                    EulerResult result =
                            algorithm.findEulerCircuit(graph);

                    EulerValidator.validate(graph, result);
                }
        );
    }

    public static void stressInvalidEulerGraph() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Invalid Euler Graph",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::invalidEulerGraph,
                graph -> {

                    try {
                        algorithm.findEulerPath(graph);
                        throw new AssertionError(
                                "Expected GraphCycleException."
                        );
                    } catch (GraphCycleException ignored) {
                    }
                }
        );
    }

    public static void stressDisconnectedEulerGraph() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Disconnected Euler Graph",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::disconnectedEulerGraph,
                graph -> {

                    try {
                        algorithm.findEulerPath(graph);
                        throw new AssertionError(
                                "Expected GraphDisconnectedException."
                        );
                    } catch (GraphDisconnectedException ignored) {
                    }

                }
        );
    }
}
