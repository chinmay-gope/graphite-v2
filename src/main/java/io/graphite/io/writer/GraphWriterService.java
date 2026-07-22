package io.graphite.io.writer;

import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public final class GraphWriterService extends GraphAPI {

    public GraphWriterService(IGraph graph) {
        super(graph);
    }

    public void edgeList(Path path) throws IOException {
        new PrettyEdgeListWriter().write(path, graph);
    }
}
