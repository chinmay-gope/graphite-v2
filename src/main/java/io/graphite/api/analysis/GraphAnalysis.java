package main.java.io.graphite.api.analysis;

public interface GraphAnalysis {

    // Structural
    boolean isConnected();

    boolean isTree();

    boolean isForest();

    // Classification
    boolean isBipartite();

    boolean isEulerian();

    boolean isCyclic();

    // Metrics
    int maxDegree();

    int minDegree();

    double averageDegree();

    double density();

    //Summary
    GraphAnalysisResult analyze();

}
