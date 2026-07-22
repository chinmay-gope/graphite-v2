package io.graphite.examples.algorithm;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;

public final class TopologyExamples {

    private static final IGraph DAG =
            Graphs.patterns().dag(8);

    private TopologyExamples() {
    }

    private static void dfsTopologicalSort() {

        ExamplePrinter.feature("DFS Topological Sort");

        ExamplePrinter.graph(DAG);

        ExamplePrinter.api(
                "graph.topology().dfs()"
        );

        ExamplePrinter.result(
                DAG.topology().dfs()
        );
    }

    private static void kahnTopologicalSort() {

        ExamplePrinter.feature("Kahn's Topological Sort");

        ExamplePrinter.graph(DAG);

        ExamplePrinter.api(
                "graph.topology().kahn()"
        );

        ExamplePrinter.result(
                DAG.topology().kahn()
        );
    }

    public static void run() {

        ExamplePrinter.title("Topological Sorting Examples");

        dfsTopologicalSort();

        kahnTopologicalSort();
    }
}
