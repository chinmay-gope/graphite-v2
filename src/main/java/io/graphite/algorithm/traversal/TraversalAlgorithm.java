package main.java.io.graphite.algorithm.traversal;

import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.TraversalResult;

public interface TraversalAlgorithm {
    TraversalResult traverse(IGraph graph, int source);
}
