package io.graphite.io.writer;

import io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public final class GraphWriterService {
    private final IGraph graph;

    public GraphWriterService(IGraph graph) {
        this.graph = graph;
    }

    public void edgeList(Path path) throws IOException {
        new PrettyEdgeListWriter().write(path, graph);
    }
}
