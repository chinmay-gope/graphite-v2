package io.graphite.examples.algorithm;

import io.graphite.examples.ExamplePrinter;
import io.graphite.generator.preset.GraphPresetGenerator;
import io.graphite.graph.IGraph;

public class TraversalExamples {

    private static final IGraph GRAPH =
            GraphPresetGenerator.traversalGraph(8);

    private TraversalExamples() {
    }

    private static void breadthFirstSearch() {

        ExamplePrinter.feature("Breadth First Search");

        ExamplePrinter.api(
                "graph.traversal().bfs(0)"
        );

        ExamplePrinter.note(
                "Visits vertices level by level from the source vertex."
        );

        ExamplePrinter.result(
                GRAPH.traversal().bfs(0)
        );
    }

    private static void depthFirstSearch() {

        ExamplePrinter.feature("Depth First Search");

        ExamplePrinter.api(
                "graph.traversal().dfs(0)"
        );

        ExamplePrinter.note(
                "Explores each branch before backtracking."
        );

        ExamplePrinter.result(
                GRAPH.traversal().dfs(0)
        );
    }

    public static void run() {
        ExamplePrinter.title("Traversal Examples");
        ExamplePrinter.graph(GRAPH);

        breadthFirstSearch();
        depthFirstSearch();
    }
}
