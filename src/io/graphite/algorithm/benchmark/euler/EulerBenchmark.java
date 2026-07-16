package io.graphite.algorithm.benchmark.euler;

import io.graphite.algorithm.benchmark.StressConfig;
import io.graphite.algorithm.benchmark.StressRunner;
import io.graphite.algorithm.euler.EulerAlgorithm;
import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.algorithm.exception.algorithm.GraphCycleException;
import io.graphite.algorithm.exception.graph.GraphDisconnectedException;
import io.graphite.algorithm.result.EulerResult;
import io.graphite.algorithm.validation.EulerValidator;
import io.graphite.algorithm.graph.GraphFactory;

public class EulerBenchmark {
    public static void stressEulerPath() {

        EulerAlgorithm algorithm = new Hierholzer();

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

        EulerAlgorithm algorithm = new Hierholzer();

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

        EulerAlgorithm algorithm = new Hierholzer();

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

        EulerAlgorithm algorithm = new Hierholzer();

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
