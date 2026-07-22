package main.java.io.graphite.io.reader;

import main.java.io.graphite.graph.IGraph;

import java.io.IOException;
import java.nio.file.Path;

public final class GraphReaderService {

    public static final GraphReaderService INSTANCE = new GraphReaderService();

    private GraphReaderService() {
    }

    public IGraph edgeList(Path path)
            throws IOException {
        return new EdgeListReader().read(path);
    }
}
