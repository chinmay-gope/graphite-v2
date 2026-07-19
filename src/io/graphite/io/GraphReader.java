package io.graphite.io;

import io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public interface GraphReader {
    IGraph read(Path path) throws IOException;
}
