package io.graphite.algorithm.examples.bipartite;

import io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import io.graphite.algorithm.bipartite.DFSBipartiteChecker;
import io.graphite.algorithm.bipartite.BipartiteAlgorithm;
import io.graphite.algorithm.examples.util.GraphDemoPrinter;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.result.Result;
import io.graphite.algorithm.builder.GraphBuilder;
import io.graphite.algorithm.util.GraphPrinter;
import io.graphite.algorithm.validation.GraphValidator;

public class BipartiteDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        GraphDemoPrinter.printHeader("Bipartite Even Cycle", graph);
        GraphPrinter.print(graph);

        BipartiteAlgorithm bfsBipartiteChecker = new BFSBipartiteChecker();
        BipartiteAlgorithm dfsBipartiteChecker = new DFSBipartiteChecker();

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);


        graph = GraphBuilder
                .undirected(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();
        GraphDemoPrinter.printHeader("Bipartite Odd Cycle", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(2)
                .addEdge(0, 0)
                .addEdge(0, 1)
                .build();
        GraphDemoPrinter.printHeader("SelfLoop", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .build();
        GraphDemoPrinter.printHeader("Bipartite Tree", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(4)
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

        graph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .build();
        GraphDemoPrinter.printHeader("Disconnected Bipartite", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 2)
                .addEdge(5, 6)
                .build();
        GraphDemoPrinter.printHeader("Disconnected (One Bad Component)", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .addEdge(0, 2)
                .build();
        GraphDemoPrinter.printHeader("Square With Diagonal", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(9)
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

    private static String colorizeResult(boolean isBipartite, Graph graph) {
        if (GraphValidator.hasSelfLoop(graph)) {
            return Result.YELLOW + "self-loop detected" + Result.RESET;
        }
        if (!isBipartite) {
            return Result.RED + "false" + Result.RESET;
        }
        return Result.GREEN + "true" + Result.RESET;
    }

    private static void checkIsBipartite(Graph graph,
                                         BipartiteAlgorithm dfsChecker,
                                         BipartiteAlgorithm bfsChecker) {
        boolean dfsResult = dfsChecker.isBipartite(graph);
        boolean bfsResult = bfsChecker.isBipartite(graph);
        System.out.println("isBipartite (dfs): " + colorizeResult(dfsResult, graph));
        System.out.println("isBipartite (bfs): " + colorizeResult(bfsResult, graph));
    }

}
