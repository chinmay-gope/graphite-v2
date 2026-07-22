package io.graphite.algorithm.traversal;

import io.graphite.graph.IGraph;
import io.graphite.result.TraversalResult;

public interface TraversalAlgorithm {
    TraversalResult traverse(IGraph graph, int source);
}
