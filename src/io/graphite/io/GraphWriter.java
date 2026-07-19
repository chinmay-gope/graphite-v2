package io.graphite.io;

import io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public interface GraphWriter {
    void write(Path path, IGraph graph) throws IOException;
}
