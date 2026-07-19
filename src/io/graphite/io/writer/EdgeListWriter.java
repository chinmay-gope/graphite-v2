package io.graphite.io.writer;

import io.graphite.graph.IGraph;
import io.graphite.io.GraphWriter;
import io.graphite.model.Edge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class EdgeListWriter implements GraphWriter {

    @Override
    public void write(Path path, IGraph graph) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            // Header
            writer.write("# Graphite Edge List v1");
            writer.newLine();

            // Graph metadata
            writer.write(
                    "V : " + graph.vertexCount() + "," +
                            " E : " + graph.edgeCount() + "," +
                            " D : " + graph.isDirected() + "," +
                            " W : " + graph.isWeighted()
            );
            writer.newLine();

            // Edges
            for (Edge edge : graph.edges()) {
                if (graph.isWeighted()) {
                    writer.write(
                            edge.source() + " " +
                                    edge.destination() + " " +
                                    edge.weight()
                    );
                } else {
                    writer.write(
                            edge.source() + " " +
                                    edge.destination()
                    );
                }
                writer.newLine();
            }
        }
    }
}
