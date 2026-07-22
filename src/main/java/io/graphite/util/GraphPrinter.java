package main.java.io.graphite.util;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.model.Edge;
import main.java.io.graphite.result.Colors;

final class GraphPrinter implements Colors {
    private GraphPrinter() {
    }

    public static void print(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            IO.print(CYAN + i + WHITE + " -> ");

            for (Edge edge : graph.neighbors(i)) {
                IO.print(YELLOW + edge + RESET + " ");
            }

            IO.println();
        }
    }

    public static void printEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.neighbors(i)) {
                System.out.printf(
                        CYAN + "%d" + RESET + " -> " +
                                YELLOW + "%d" + RESET +
                                " (weight = " + MAGENTA + "%d" + RESET + ")%n",
                        i,
                        edge.destination(),
                        edge.weight()
                );
            }
        }
    }
}
