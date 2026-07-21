package io.graphite.examples.io;

import io.graphite.builder.Graphs;
import io.graphite.examples.ExamplePrinter;
import io.graphite.graph.IGraph;
import io.graphite.print.GraphPrinter;

import java.io.IOException;
import java.nio.file.Path;

public final class GraphIOExamples {

    private GraphIOExamples() {
    }

    public static void run() throws IOException {

        ExamplePrinter.title("Graph I/O Examples");

        IGraph graph = Graphs.undirected()
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .build();

        Path path = Path.of("graph.txt");

        ExamplePrinter.feature("Write Edge List");

        ExamplePrinter.api("""
                graph.write(graph)
                      .edgeList(path);
                """);

        graph.write()
                .edgeList(path);

        ExamplePrinter.success();

        ExamplePrinter.feature("Read Edge List");

        ExamplePrinter.api("""
                IGraph loaded =
                        Graphs.read()
                              .edgeList(path);
                """);

        IGraph loaded = Graphs.read().edgeList(path);

        GraphPrinter.println(loaded);
    }

}
