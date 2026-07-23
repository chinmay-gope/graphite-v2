package io.graphite.io.writer;

import io.graphite.api.analysis.GraphAnalysis;
import io.graphite.graph.IGraph;
import io.graphite.io.GraphWriter;
import io.graphite.model.Edge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PrettyEdgeListWriter implements GraphWriter {
    private static void line(BufferedWriter writer, String format, Object... args)
            throws IOException {
        writer.write(String.format(format, args));
        writer.newLine();
    }

    @Override
    public void write(Path path, IGraph graph) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("=== Graphite Edge Printer V2 ===");
            writer.newLine();
            writer.newLine();

            // Graph metadata block
            GraphAnalysis analysis = graph.analysis();

            line(writer, "Graph Summary");
            line(writer, "");

            line(writer, "  Vertices     : %d", graph.vertexCount());
            line(writer, "  Edges        : %d", graph.edgeCount());
            line(writer, "  Directed     : %s", graph.isDirected() ? "Yes" : "No");
            line(writer, "  Weighted     : %s", graph.isWeighted() ? "Yes" : "No");
            line(writer, "  Connected    : %s", analysis.isConnected() ? "Yes" : "No");
            line(writer, "  Cyclic       : %s", analysis.isCyclic() ? "Yes" : "No");
            line(writer, "  Tree         : %s", analysis.isTree() ? "Yes" : "No");
            line(writer, "  Forest       : %s", analysis.isForest() ? "Yes" : "No");
            line(writer, "  Bipartite    : %s", analysis.isBipartite() ? "Yes" : "No");
            line(writer, "  Eulerian     : %s", analysis.isEulerian() ? "Yes" : "No");
            line(writer, "  Density      : %.4f", analysis.density());
            line(writer, "  Avg Degree   : %.2f", analysis.averageDegree());
            line(writer, "  Max Degree   : %d", analysis.maxDegree());
            line(writer, "  Min Degree   : %d", analysis.minDegree());

            writer.newLine();

            // Edge list header
            line(writer, "-----------------------------------------------");
            writer.write(String.format("%-6s %-15s %-15s %-10s", "Index", "Source", "Destination", graph.isWeighted() ? "Weight" : ""));
            writer.newLine();
            line(writer, "-----------------------------------------------");

            // Graph Info
            int index = 1;
            for (Edge edge : graph.edges()) {
                if (graph.isWeighted()) {
                    writer.write(String.format(
                            "[%03d]   %-15s %-15s %-10s",
                            index++,
                            edge.source(),
                            edge.destination(),
                            edge.weight()
                    ));
                } else {
                    writer.write(String.format(
                            "[%03d]   %-15s %-15s",
                            index++,
                            edge.source(),
                            edge.destination()
                    ));
                }
                writer.newLine();
            }

        }
    }
}
