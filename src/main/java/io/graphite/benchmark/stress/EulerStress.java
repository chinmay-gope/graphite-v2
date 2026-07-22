package main.java.io.graphite.benchmark.stress;

import main.java.io.graphite.algorithm.euler.EulerAlgorithm;
import main.java.io.graphite.algorithm.euler.Hierholzer;
import main.java.io.graphite.benchmark.StressConfig;
import main.java.io.graphite.benchmark.StressRunner;
import main.java.io.graphite.exception.algorithm.GraphCycleException;
import main.java.io.graphite.exception.graph.GraphDisconnectedException;
import main.java.io.graphite.generator.example.GraphExampleGenerator;
import main.java.io.graphite.result.EulerResult;
import main.java.io.graphite.validation.EulerValidator;

public class EulerStress {

    private EulerStress() {

    }

    private static void stressEulerPath() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Euler Path Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphExampleGenerator::eulerPathGraph,
                graph -> {

                    EulerResult result =
                            algorithm.findEulerPath(graph);

                    EulerValidator.validate(graph, result);
                }
        );
    }

    private static void stressEulerCircuit() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Euler Circuit Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphExampleGenerator::eulerCircuitGraph,
                graph -> {

                    EulerResult result =
                            algorithm.findEulerCircuit(graph);

                    EulerValidator.validate(graph, result);
                }
        );
    }

    private static void stressInvalidEulerGraph() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Invalid Euler Graph",
                StressConfig.DEFAULT_CONFIG,
                GraphExampleGenerator::invalidEulerGraph,
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

    private static void stressDisconnectedEulerGraph() {

        EulerAlgorithm algorithm = Hierholzer.INSTANCE;

        StressRunner.run(
                "Disconnected Euler Graph",
                StressConfig.DEFAULT_CONFIG,
                GraphExampleGenerator::disconnectedEulerGraph,
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

    public static void run() {
        stressEulerPath();
        stressEulerCircuit();
        stressInvalidEulerGraph();
        stressDisconnectedEulerGraph();
    }

    static void main(String[] args) {
        run();
    }

}
