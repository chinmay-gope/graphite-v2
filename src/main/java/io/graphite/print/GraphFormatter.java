package main.java.io.graphite.print;

import main.java.io.graphite.graph.IGraph;

// Strategy
public interface GraphFormatter {
    String format(IGraph graph);
}
