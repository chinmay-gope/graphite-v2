package io.graphite.examples.bipartite;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.BipartiteAlgorithm;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.builder.Graphs;
import io.graphite.examples.util.GraphDemoPrinter;
import io.graphite.graph.IGraph;
import io.graphite.result.Colors;
import io.graphite.util.GraphPrinter;
import io.graphite.validation.GraphValidator;

public class BipartiteDemo implements Colors {
    static void main() {
        IGraph graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        io.graphite.examples.util.GraphDemoPrinter.printHeader("Bipartite Even Cycle", graph);
        GraphPrinter.print(graph);

        BipartiteAlgorithm bfsBipartiteChecker = BFSBipartiteChecker.INSTANCE;
        BipartiteAlgorithm dfsBipartiteChecker = DFSBipartiteChecker.INSTANCE;

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);


        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();
        GraphDemoPrinter.printHeader("Bipartite Odd Cycle", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 0)
                .addEdge(0, 1)
                .build();
        GraphDemoPrinter.printHeader("SelfLoop", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .build();
        GraphDemoPrinter.printHeader("Bipartite Tree", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .addEdge(1, 2)
                .addEdge(1, 3)
                .addEdge(2, 3)
                .build();
        GraphDemoPrinter.printHeader("Bipartite K4", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .build();
        GraphDemoPrinter.printHeader("Disconnected Bipartite", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 2)
                .addEdge(5, 6)
                .build();
        GraphDemoPrinter.printHeader("Disconnected (One Bad Component)", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .addEdge(0, 2)
                .build();
        GraphDemoPrinter.printHeader("Square With Diagonal", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = Graphs
                .undirected()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(6, 7)
                .addEdge(7, 8)
                .addEdge(0, 3)
                .addEdge(3, 6)
                .addEdge(1, 4)
                .addEdge(4, 7)
                .addEdge(2, 5)
                .addEdge(5, 8)
                .build();
        GraphDemoPrinter.printHeader("Large Grid", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);
    }

    private static String colorizeResult(boolean isBipartite, IGraph graph) {
        if (GraphValidator.hasSelfLoop(graph)) {
            return YELLOW + "self-loop detected" + RESET;
        }
        if (!isBipartite) {
            return RED + "false" + RESET;
        }
        return GREEN + "true" + RESET;
    }

    private static void checkIsBipartite(IGraph graph,
                                         BipartiteAlgorithm dfsChecker,
                                         BipartiteAlgorithm bfsChecker) {
        boolean dfsResult = dfsChecker.isBipartite(graph);
        boolean bfsResult = bfsChecker.isBipartite(graph);
        System.out.println("isBipartite (dfs): " + colorizeResult(dfsResult, graph));
        System.out.println("isBipartite (bfs): " + colorizeResult(bfsResult, graph));
    }

}
