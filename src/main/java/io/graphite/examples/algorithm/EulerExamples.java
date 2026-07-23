package io.graphite.examples.algorithm;

import io.graphite.examples.ExamplePrinter;
import io.graphite.exception.GraphException;
import io.graphite.generator.example.GraphExampleGenerator;
import io.graphite.graph.IGraph;

public final class EulerExamples {

    private static final IGraph PATH =
            GraphExampleGenerator.eulerPathGraph(8);

    private static final IGraph CIRCUIT =
            GraphExampleGenerator.eulerCircuitGraph(8);

    private static final IGraph INVALID =
            GraphExampleGenerator.invalidEulerGraph(8);

    private EulerExamples() {
    }

    private static void eulerPath() {

        ExamplePrinter.feature("Euler Path");

        ExamplePrinter.graph(PATH);

        ExamplePrinter.api(
                "graph.euler().path()"
        );

        ExamplePrinter.result(
                PATH.euler().path()
        );
    }

    private static void eulerCircuit() {

        ExamplePrinter.feature("Euler Circuit");

        ExamplePrinter.graph(CIRCUIT);

        ExamplePrinter.api(
                "graph.euler().circuit()"
        );

        ExamplePrinter.result(
                CIRCUIT.euler().circuit()
        );
    }

    private static void invalidEulerGraph() {

        ExamplePrinter.feature("Invalid Euler Graph");

        ExamplePrinter.graph(INVALID);

        ExamplePrinter.api(
                "graph.euler().path()"
        );

        try {

            ExamplePrinter.result(
                    INVALID.euler().path()
            );

        } catch (GraphException e) {

            ExamplePrinter.failure(e);
        }
    }

    public static void run() {

        ExamplePrinter.title("Euler Path Examples");

        eulerPath();

        eulerCircuit();

        invalidEulerGraph();
    }
}
