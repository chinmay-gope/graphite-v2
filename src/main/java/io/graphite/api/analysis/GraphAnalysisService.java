package main.java.io.graphite.api.analysis;

import main.java.io.graphite.algorithm.bipartite.BFSBipartiteChecker;
import main.java.io.graphite.algorithm.cycle.DirectedCycleDetector;
import main.java.io.graphite.algorithm.cycle.UndirectedCycleDetector;
import main.java.io.graphite.algorithm.euler.Hierholzer;
import main.java.io.graphite.api.internal.GraphAPI;
import main.java.io.graphite.exception.GraphException;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.util.GraphUtils;


public final class GraphAnalysisService extends GraphAPI implements GraphAnalysis {

    public GraphAnalysisService(IGraph graph) {
        super(graph);
    }

    // ==========================================================
    // Structural Properties
    // ==========================================================

    @Override
    public boolean isConnected() {
        return GraphUtils.isConnected(graph);
    }

    @Override
    public boolean isTree() {
        return isConnected() && !isCyclic();
    }

    @Override
    public boolean isForest() {
        return !isCyclic();
    }

    @Override
    public boolean isCyclic() {
        if (graph.isDirected()) {
            return DirectedCycleDetector.INSTANCE.hasCycle(graph);
        }

        return UndirectedCycleDetector.INSTANCE.hasCycle(graph);
    }

    // ==========================================================
    // Connectivity
    // ==========================================================

    @Override
    public boolean isBipartite() {
        return BFSBipartiteChecker.INSTANCE.isBipartite(graph);
    }

    @Override
    public boolean isEulerian() {
        try {
            Hierholzer.INSTANCE.findEulerCircuit(graph);
            return true;
        } catch (GraphException e) {
            return false;
        }
    }

    // ==========================================================
    // Metrics
    // ==========================================================

    @Override
    public int maxDegree() {
        if (graph.vertexCount() == 0) {
            return 0;
        }

        int max = 0;

        for (int v = 0; v < vertices(); v++) {
            max = Math.max(max, graph.degree(v));
        }

        return max;
    }

    @Override
    public int minDegree() {
        if (graph.vertexCount() == 0) {
            return 0;
        }

        int min = graph.degree(0);

        for (int v = 1; v < vertices(); v++) {
            min = Math.min(min, graph.degree(v));
        }

        return min;
    }

    private int vertices() {
        return graph.vertexCount();
    }

    @Override
    public double averageDegree() {

        if (graph.vertexCount() == 0) {
            return 0;
        }

        if (graph.isDirected()) {
            return (double) graph.edgeCount() / graph.vertexCount(); // E / V
        }

        return (2.0 * graph.edgeCount()) / graph.vertexCount(); // ( 2 * E ) / V
    }

    @Override
    public double density() {

        int v = graph.vertexCount();

        if (v < 2) {
            return 0;
        }

        if (graph.isDirected()) {
            return (double) graph.edgeCount()
                    / (v * (v - 1)); // E / (V * (V - 1))
        }

        return (2.0 * graph.edgeCount())
                / (v * (v - 1)); // (2 * E) / (V * (V - 1))
    }

    @Override
    public GraphAnalysisResult analyze() {
        return new GraphAnalysisResult(
                graph.vertexCount(),
                graph.edgeCount(),
                graph.isDirected(),
                graph.isWeighted(),
                isConnected(),
                isTree(),
                isForest(),
                isBipartite(),
                isEulerian(),
                isCyclic(),
                density(),
                averageDegree(),
                maxDegree(),
                minDegree()
        );
    }

}
