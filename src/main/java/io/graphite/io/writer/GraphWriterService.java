package main.java.io.graphite.io.writer;

import main.java.io.graphite.api.internal.GraphAPI;
import main.java.io.graphite.graph.IGraph;

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
