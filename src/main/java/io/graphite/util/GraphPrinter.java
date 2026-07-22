package io.graphite.util;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.result.Colors;

final class GraphPrinter implements Colors {
    private GraphPrinter() {
    }

    public static void print(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.print(CYAN + i + WHITE + " -> ");

            for (Edge edge : graph.neighbors(i)) {
                System.out.print(YELLOW + edge + RESET + " ");
            }

            System.out.println();
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
