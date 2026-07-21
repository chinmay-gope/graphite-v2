package io.graphite.examples.util;

import io.graphite.graph.IGraph;
import io.graphite.result.Colors;

public final class GraphDemoPrinter implements Colors {

    private GraphDemoPrinter() {
    }

    public static void printHeader(String algorithm, IGraph graph) {
        printFooter();
        var graphType = graph.isDirected() ? "DIRECTED" : "UNDIRECTED";
        System.out.println(WHITE + "Algorithm : " + RESET + CYAN + algorithm + RESET);
        System.out.println(WHITE + "Graph Type: " + RESET + YELLOW + graphType + RESET);
        System.out.println(WHITE + "Vertices  : " + RESET + MAGENTA + graph.getVertices() + RESET);
        printFooter();
    }

    public static void printFooter() {
        IO.println("================================================================================");
    }
}
