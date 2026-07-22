package main.java.io.graphite.examples.algorithm;

import main.java.io.graphite.examples.ExamplePrinter;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

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
