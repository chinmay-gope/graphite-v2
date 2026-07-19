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
            // Header with some flair
            writer.write("=======================================");
            writer.newLine();
            writer.write("   ✨ Graphite Edge Printer V2 ✨");
            writer.newLine();
            writer.write("=======================================");
            writer.newLine();

            // Graph metadata block
            writer.write(String.format(
                    "Vertices : %-5d | Edges : %-5d | Directed : %-5s | Weighted : %-5s",
                    graph.vertexCount(),
                    graph.edgeCount(),
                    graph.isDirected(),
                    graph.isWeighted()
            ));
            writer.newLine();
            writer.write("---------------------------------------");
            writer.newLine();

            // Edges with numbering and formatting
            int index = 1;
            for (Edge edge : graph.edges()) {
                if (graph.isWeighted()) {
                    writer.write(String.format(
                            "[%03d] %s --> %s (w=%s)",
                            index++,
                            edge.source(),
                            edge.destination(),
                            edge.weight()
                    ));
                } else {
                    writer.write(String.format(
                            "[%03d] %s --> %s",
                            index++,
                            edge.source(),
                            edge.destination()
                    ));
                }
                writer.newLine();
            }

            // Footer
            writer.write("---------------------------------------");
            writer.newLine();
            writer.write("   ✅ Printing complete. Enjoy your graph!");
            writer.newLine();
            writer.write("=======================================");
        }
    }
}
