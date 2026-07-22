package main.java.io.graphite.examples.core;


import main.java.io.graphite.builder.Graphs;
import main.java.io.graphite.examples.ExamplePrinter;
import main.java.io.graphite.generator.preset.GraphPresetGenerator;
import main.java.io.graphite.graph.IGraph;

public final class GeneratorExamples {

    private GeneratorExamples() {
    }

    private static void randomGraph() {

        IGraph graph = Graphs.random()
                .undirected()
                .vertices(10)
                .edges(15)
                .connected()
                .build();

        ExamplePrinter.feature("Random Graph");

        ExamplePrinter.api("""
                Graphs.random()
                      .undirected()
                      .vertices(10)
                      .edges(15)
                      .connected()
                      .build()
                """);

        ExamplePrinter.graph(graph);
    }

    private static void traversalPreset() {

        IGraph graph = GraphPresetGenerator
                .traversalGraph(10);

        ExamplePrinter.feature("Traversal Preset");

        ExamplePrinter.api("""
                Graphs.presets()
                      .traversalGraph(10)
                """);

        ExamplePrinter.graph(graph);
    }

    private static void treePattern() {

        IGraph graph = Graphs.patterns()
                .tree(10);

        ExamplePrinter.feature("Tree Pattern");

        ExamplePrinter.api("""
                Graphs.patterns()
                      .tree(10)
                """);

        ExamplePrinter.graph(graph);
    }

    private static void completePattern() {

        IGraph graph = Graphs.patterns()
                .complete(8);

        ExamplePrinter.feature("Complete Graph");

        ExamplePrinter.api("""
                Graphs.patterns()
                      .complete(8)
                """);

        ExamplePrinter.graph(graph);
    }

    private static void dagPattern() {

        IGraph graph = Graphs.patterns()
                .dag(10);

        ExamplePrinter.feature("Directed Acyclic Graph");

        ExamplePrinter.api("""
                Graphs.patterns()
                      .dag(10)
                """);

        ExamplePrinter.graph(graph);
    }

    public static void run() {

        ExamplePrinter.title("Generator Examples");

        randomGraph();

        traversalPreset();

        treePattern();

        completePattern();

        dagPattern();
    }
}
