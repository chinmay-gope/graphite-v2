package io.graphite.algorithm.util;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;

import static io.graphite.algorithm.result.Result.*;

public final class GraphPrinter {

    private GraphPrinter() {
        throw new AssertionError("No GraphPrinter instances for you!");
    }

    public static void print(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            IO.print(CYAN + i + WHITE + " -> ");

            for (Edge edge : graph.getNeighbours(i)) {
                IO.print(YELLOW + edge + RESET + " ");
            }

            IO.println();
        }
    }

    public static void printEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
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
