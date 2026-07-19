package io.graphite.print;

import io.graphite.graph.IGraph;

// Strategy
public interface GraphFormatter {
    String format(IGraph graph);
}
