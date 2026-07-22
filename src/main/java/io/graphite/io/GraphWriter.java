package main.java.io.graphite.io;

import main.java.io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public interface GraphWriter {
    void write(Path path, IGraph graph) throws IOException;
}
