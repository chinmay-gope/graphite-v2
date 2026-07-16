package io.graphite.algorithm.examples.util;

import io.graphite.algorithm.graph.IGraph;

import static io.graphite.algorithm.result.Result.*;

public final class GraphDemoPrinter {

    private GraphDemoPrinter() {
        throw new AssertionError("No GraphDemoPrinter instances for you!");
    }

    public static void printHeader(String algorithm, IGraph graph) {
        printFooter();
        System.out.println(WHITE + "Algorithm : " + RESET + CYAN + algorithm + RESET);
        System.out.println(WHITE + "Graph Type: " + RESET + YELLOW + graph.getGraphType() + RESET);
        System.out.println(WHITE + "Vertices  : " + RESET + MAGENTA + graph.getVertices() + RESET);
        printFooter();
    }

    public static void printFooter() {
        IO.println("================================================================================");
    }
}
