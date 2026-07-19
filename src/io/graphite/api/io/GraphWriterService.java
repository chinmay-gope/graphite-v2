package io.graphite.api.io;

import io.graphite.graph.IGraph;
import io.graphite.io.writer.EdgeListWriter;

import java.io.IOException;
import java.nio.file.Path;

public final class GraphWriterService {
    private final IGraph graph;
    private GraphWriterService writer;

    public GraphWriterService(IGraph graph) {
        this.graph = graph;
    }

    public void edgeList(Path path) throws IOException {
        new EdgeListWriter().write(path, graph);
    }
}
