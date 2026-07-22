package io.graphite.examples.algorithm;

import io.graphite.examples.ExamplePrinter;
import io.graphite.generator.preset.GraphPresetGenerator;
import io.graphite.graph.IGraph;

public final class BipartiteExamples {

    private static final IGraph GRAPH =
            GraphPresetGenerator.bipartiteGraph(10);

    private BipartiteExamples() {
    }

    private static void bfsBipartiteCheck() {

        ExamplePrinter.feature("Breadth-First Bipartite Check");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.bipartite().bfs()"
        );

        ExamplePrinter.result(
                GRAPH.bipartite().bfs()
        );
    }

    private static void dfsBipartiteCheck() {

        ExamplePrinter.feature("Depth-First Bipartite Check");

        ExamplePrinter.graph(GRAPH);

        ExamplePrinter.api(
                "graph.bipartite().dfs()"
        );

        ExamplePrinter.result(
                GRAPH.bipartite().dfs()
        );
    }

    public static void run() {

        ExamplePrinter.title("Bipartite Graph Examples");

        bfsBipartiteCheck();

        dfsBipartiteCheck();
    }
}
