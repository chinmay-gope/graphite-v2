package io.graphite.examples;

import io.graphite.api.analysis.GraphAnalysisResult;
import io.graphite.builder.Graphs;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.print.GraphPrinter;

public final class GraphDemo {

    static void main() {
        new GraphDemo().executeThemAll();
    }

    void executeThemAll() {
        immutableDemo();
        copyDemo();
        transposeDemo();

        directedDemo();
        undirectedDemo();

        servicesDemo();

        randomGeneratorDemo();

        treeGeneratorDemo();
        starGeneratorDemo();
        wheelGeneratorDemo();
        gridGeneratorDemo();
        cycleGeneratorDemo();
        completeGeneratorDemo();
        completeBipartiteGeneratorDemo();
        bipartiteGeneratorDemo();

        generatorStressDemo();

        graphFactoryDemo();

        analysisDemo();

        printerDemo();

    }

    // ---------------------------------------------------------
    // Services
    // ---------------------------------------------------------
    private static void servicesDemo() {

        header("Services Demo");

        // ==========================================================
        // Traversal
        // ==========================================================

        IGraph traversal = Graphs
                .undirected()
                .vertices(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .addEdge(4, 5)
                .build();

        System.out.println("\nTraversal");
        print(traversal);
        System.out.println(traversal.traversal().bfs(0));
        System.out.println(traversal.traversal().dfs(0));


        // ==========================================================
        // Cycle Detection
        // ==========================================================

        IGraph cycle = Graphs
                .undirected()
                .vertices(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();

        System.out.println("\nCycle Detection");
        print(cycle);
        System.out.println(cycle.cycle().undirected());


        // ==========================================================
        // Bipartite
        // ==========================================================

        IGraph bipartite = Graphs
                .undirected()
                .vertices(6)
                .addEdge(0, 3)
                .addEdge(0, 4)
                .addEdge(1, 3)
                .addEdge(1, 5)
                .addEdge(2, 4)
                .addEdge(2, 5)
                .build();

        System.out.println("\nBipartite");
        print(bipartite);
        System.out.println(bipartite.bipartite().bfs());
        System.out.println(bipartite.bipartite().dfs());


        // ==========================================================
        // Minimum Spanning Tree
        // ==========================================================

        IGraph mst = Graphs
                .undirected()
                .weighted(true)
                .vertices(5)
                .addEdge(0, 1, 2)
                .addEdge(0, 2, 6)
                .addEdge(1, 2, 3)
                .addEdge(1, 3, 8)
                .addEdge(1, 4, 5)
                .addEdge(2, 4, 7)
                .addEdge(3, 4, 9)
                .build();

        System.out.println("\nMinimum Spanning Tree");
        print(mst);
        System.out.println(mst.mst().prim(0));
        System.out.println(mst.mst().kruskal());


        // ==========================================================
        // Shortest Path
        // ==========================================================

        IGraph shortest = Graphs
                .directed()
                .weighted(true)
                .vertices(5)
                .addEdge(0, 1, 10)
                .addEdge(0, 3, 5)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 2)
                .addEdge(2, 4, 4)
                .addEdge(3, 1, 3)
                .addEdge(3, 2, 9)
                .addEdge(3, 4, 2)
                .addEdge(4, 0, 7)
                .addEdge(4, 2, 6)
                .build();

        System.out.println("\nShortest Path");
        print(shortest);
        System.out.println(shortest.shortestPath().dijkstra(0));
        System.out.println(shortest.shortestPath().bellmanFord(0));
        System.out.println(shortest.shortestPath().floydWarshall());


        // ==========================================================
        // Connectivity
        // ==========================================================

        IGraph connectivity = Graphs
                .undirected()
                .vertices(7)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .addEdge(3, 5)
                .addEdge(5, 6)
                .build();

        System.out.println("\nConnectivity");
        print(connectivity);
        System.out.println(connectivity.connectivity().articulationPoints());
        System.out.println(connectivity.connectivity().bridges());
        System.out.println(connectivity.connectivity().biconnectedComponents());


        // ==========================================================
        // Strongly Connected Components
        // ==========================================================

        IGraph scc = Graphs
                .directed()
                .vertices(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .build();

        System.out.println("\nStrongly Connected Components");
        print(scc);
        System.out.println(scc.connectivity().stronglyConnectedComponents());


        // ==========================================================
        // Topological Sorting
        // ==========================================================

        IGraph dag = Graphs
                .directed()
                .vertices(6)
                .addEdge(5, 2)
                .addEdge(5, 0)
                .addEdge(4, 0)
                .addEdge(4, 1)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        System.out.println("\nTopological Sort");
        print(dag);
        System.out.println(dag.topology().kahn()); // 3, 4, 5, 1, 2, 0 or
        System.out.println(dag.topology().dfs()); //  5, 4, 2, 3, 1, 0


        // ==========================================================
        // Analysis
        // ==========================================================

        System.out.println("\nAnalysis");
        System.out.println(traversal.analysis().density());
        System.out.println(traversal.analysis().averageDegree());
        System.out.println(traversal.analysis().isTree());

        // ==========================================================
        // Euler
        // ==========================================================

        IGraph euler = Graphs
                .undirected()
                .vertices(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .addEdge(0, 4)
                .addEdge(4, 2)
                .build();

        System.out.println("\nEuler");
        print(euler);
        System.out.println(euler.euler().path());

        try {
            System.out.println(euler.euler().circuit());
        } catch (GraphException e) {
            System.err.println("Graph is not Eulerian: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Builder
    // ---------------------------------------------------------

    private static void builderDemo() {

        header("Builder Demo");

        IGraph graph = Graphs
                .undirected()
                .vertices(6)
                .weighted(true)
                .immutable(false)
                .addEdge(0, 1, 5)
                .addEdge(0, 2, 2)
                .addEdge(1, 3, 7)
                .addEdge(2, 4, 4)
                .addEdge(4, 5, 1)
                .build();

        print(graph);

        System.out.println("\nRemoving edge (0,1)");
        graph.removeEdge(0, 1);

        print(graph);

        System.out.println("\nBuilder.from()");

        IGraph rebuilt = Graphs
                .undirected()
                .from(graph)
                .build();

        print(rebuilt);
    }

    // ---------------------------------------------------------
    // Immutable
    // ---------------------------------------------------------
    private static void immutableDemo() {

        header("Immutable Graph Demo");

        IGraph graph = Graphs
                .undirected()
                .vertices(5)
                .immutable(true)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .build();

        print(graph);

        try {

            graph.addEdge(3, 4);

            System.out.println("FAILED");

        } catch (Exception e) {

            System.out.println("PASS : " + e.getMessage());
        }

        try {

            graph.removeEdge(0, 1);

            System.out.println("FAILED");

        } catch (Exception e) {

            System.out.println("PASS : " + e.getMessage());
        }

        try {

            graph.clear();

            System.out.println("FAILED");

        } catch (Exception e) {

            System.out.println("PASS : " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Copy
    // ---------------------------------------------------------
    private static void copyDemo() {

        header("Copy Demo");

        IGraph graph = Graphs
                .undirected()
                .vertices(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .build();

        IGraph copy = graph.copy();

        copy.addEdge(2, 3);

        System.out.println("Original");

        print(graph);

        System.out.println();

        System.out.println("Copy");

        print(copy);
    }

    // ---------------------------------------------------------
    // Transpose
    // ---------------------------------------------------------

    private static void transposeDemo() {

        header("Transpose Demo");

        IGraph graph = Graphs
                .directed()
                .vertices(5)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(4, 0)
                .build();

        System.out.println("Original");

        GraphPrinter.compact(graph);

        System.out.println();

        System.out.println("Transpose");

        GraphPrinter.compact(graph.transpose());
    }

    // ---------------------------------------------------------
    // Directed
    // ---------------------------------------------------------

    private static void directedDemo() {

        header("Directed Graph Demo");

        IGraph graph = Graphs
                .directed()
                .vertices(6)
                .weighted(true)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 3)
                .addEdge(2, 5, 8)
                .addEdge(5, 1, 9)
                .build();

        print(graph);
    }
    // ---------------------------------------------------------
    // Undirected
    // ---------------------------------------------------------

    private static void undirectedDemo() {

        header("Undirected Graph Demo");

        IGraph graph = Graphs
                .undirected()
                .vertices(6)
                .weighted(false)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .build();

        print(graph);
    }
    // ---------------------------------------------------------
    // Random Generator
    // ---------------------------------------------------------

    private static void randomGeneratorDemo() {
    }

    // ---------------------------------------------------------
    // Pattern Generators
    // ---------------------------------------------------------

    private static void treeGeneratorDemo() {

        header("Tree Generator");

        IGraph graph = Graphs.tree(10);

        print(graph);

        System.out.println("Tree       : " + graph.analysis().isTree());
        System.out.println("Connected  : " + graph.analysis().isConnected());
        System.out.println("Cycle      : " + graph.analysis().isCyclic());
    }

    private static void starGeneratorDemo() {

        header("Star Generator");

        IGraph graph = Graphs.star(8);

        print(graph);

        System.out.println("Center Degree : " + graph.degree(0));

        for (int i = 1; i < graph.vertexCount(); i++) {

            System.out.println(
                    "Degree(" + i + ") = " +
                            graph.degree(i));
        }
    }

    private static void wheelGeneratorDemo() {

        header("Wheel Generator");

        IGraph graph = Graphs.wheel(8);

        print(graph);

        System.out.println("Connected : "
                + graph.analysis().isConnected());

        System.out.println("Cycle     : "
                + graph.analysis().isCyclic());
    }

    private static void gridGeneratorDemo() {

        header("Grid Generator");

        IGraph graph = Graphs.grid(3, 4);

        print(graph);

        System.out.println("Vertices : "
                + graph.vertexCount());

        System.out.println("Edges : "
                + graph.edgeCount());
    }

    private static void cycleGeneratorDemo() {

        header("Cycle Generator");

        IGraph graph = Graphs.cycle(8);

        print(graph);

        for (int i = 0; i < graph.vertexCount(); i++) {

            System.out.println(
                    "Degree(" + i + ") = "
                            + graph.degree(i));
        }
    }

    private static void completeGeneratorDemo() {

        header("Complete Graph Generator");

        IGraph graph = Graphs.complete(6);

        print(graph);

        for (int i = 0; i < graph.vertexCount(); i++) {

            System.out.println(
                    "Degree(" + i + ") = "
                            + graph.degree(i));
        }
    }

    private static void completeBipartiteGeneratorDemo() {

        header("Complete Bipartite Generator");

        IGraph graph = Graphs.completeBipartite(3, 4);

        print(graph);

        System.out.println("Bipartite : "
                + graph.analysis().isBipartite());

        System.out.println("Connected : "
                + graph.analysis().isConnected());
    }

    private static void bipartiteGeneratorDemo() {

        header("Random Bipartite Generator");

        IGraph graph = Graphs.bipartite(4, 5);

        print(graph);

        System.out.println("Bipartite : "
                + graph.analysis().isBipartite());

        System.out.println("Connected : "
                + graph.analysis().isConnected());
    }

    private static void generatorStressDemo() {

        header("Generator Stress");

        print(Graphs.tree(20));

        print(Graphs.star(20));

        print(Graphs.wheel(20));

        print(Graphs.cycle(20));

        print(Graphs.complete(20));

        print(Graphs.completeBipartite(10, 10));

        print(Graphs.grid(5, 5));
    }

    // ---------------------------------------------------------
    // Graph Factory
    // ---------------------------------------------------------

    private static void graphFactoryDemo() {

    }

    // ---------------------------------------------------------
    // Analysis
    // ---------------------------------------------------------

    private static void analysisDemo() {

        header("Analysis Demo");

        IGraph graph = Graphs
                .undirected()
                .vertices(6)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .build();

        print(graph);

        var analysis = graph.analysis();

        System.out.println("Connected      : " + analysis.isConnected());
        System.out.println("Tree           : " + analysis.isTree());
        System.out.println("Forest         : " + analysis.isForest());
        System.out.println("Cycle          : " + analysis.isCyclic());
        System.out.println("Bipartite      : " + analysis.isBipartite());
        System.out.println("Eulerian       : " + analysis.isEulerian());

        System.out.println();

        System.out.println("Max Degree     : " + analysis.maxDegree());
        System.out.println("Min Degree     : " + analysis.minDegree());
        System.out.println("Average Degree : " + analysis.averageDegree());
        System.out.println("Density        : " + analysis.density());

        System.out.println();

        GraphAnalysisResult analyze = graph.analysis().analyze();
        System.out.println(analyze);
    }

    // ---------------------------------------------------------
    // Printer
    // ---------------------------------------------------------

    private static void printerDemo() {

        header("Printer Demo");

        IGraph graph = Graphs
                .undirected()
                .vertices(6)
                .weighted(true)
                .addEdge(0, 1, 5)
                .addEdge(0, 2, 1)
                .addEdge(1, 4, 8)
                .addEdge(4, 5, 2)
                .build();

        System.out.println("Compact");

        GraphPrinter.compact(graph);

        System.out.println("Edge List");

        GraphPrinter.edgeList(graph);

        System.out.println("Tree");

        GraphPrinter.tree(graph);
    }

    // ---------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------

    private static void header(String title) {

        System.out.println();
        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    private static void print(IGraph graph) {

        GraphPrinter.compact(graph);

        System.out.println();
        System.out.println("Vertices : " + graph.vertexCount());
        System.out.println("Edges    : " + graph.edgeCount());
        System.out.println("Directed : " + graph.isDirected());
        System.out.println("Weighted : " + graph.isWeighted());
        System.out.println("Immutable: " + graph.asImmutable().getClass());
    }
}
