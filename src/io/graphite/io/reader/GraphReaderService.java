package io.graphite.io.reader;

import io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public final class GraphReaderService {
    public IGraph edgeList(Path path)
            throws IOException {
        return new EdgeListReader().read(path);
    }
}
