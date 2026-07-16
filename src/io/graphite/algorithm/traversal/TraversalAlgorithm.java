package io.graphite.algorithm.traversal;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.result.TraversalResult;

public interface TraversalAlgorithm {
    TraversalResult traverse(IGraph graph, int source);
}
