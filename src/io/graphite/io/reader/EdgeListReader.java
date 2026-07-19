package io.graphite.io.reader;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.Graphs;
import io.graphite.graph.IGraph;
import io.graphite.io.GraphReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class EdgeListReader implements GraphReader {

    @Override
    public IGraph read(Path path) throws IOException {

        List<String> lines = Files.readAllLines(path);

        int vertices = 0;
        boolean directed = false;
        boolean weighted = false;

        // ------------------------------------
        // Read Graph Metadata
        // ------------------------------------

        for (String line : lines) {

            line = line.trim();

            if (line.startsWith("Vertices")) {

                vertices = Integer.parseInt(
                        line.split(":")[1].trim()
                );

            } else if (line.startsWith("Directed")) {

                directed = line
                        .split(":")[1]
                        .trim()
                        .equalsIgnoreCase("Yes");

            } else if (line.startsWith("Weighted")) {

                weighted = line
                        .split(":")[1]
                        .trim()
                        .equalsIgnoreCase("Yes");
            }
        }

        // ------------------------------------
        // Create Builder
        // ------------------------------------

        AbstractGraphBuilder<?, ?> builder =
                directed
                        ? Graphs.directed()
                        : Graphs.undirected();

        builder.vertices(vertices)
                .weighted(weighted);

        // ------------------------------------
        // Read Edge List
        // ------------------------------------

        boolean readingEdges = false;

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("Index")) {
                readingEdges = true;
                continue;
            }

            if (line.startsWith("---")) {
                continue;
            }

            if (!readingEdges || line.isBlank()) {
                continue;
            }

            // Example: [001] 0 1 5
            String[] tokens = line
                    .replace("[", "")
                    .replace("]", "")
                    .trim()
                    .split("\\s+");

            if (tokens.length < 3) {
                continue;
            }

            int source = Integer.parseInt(tokens[1]);
            int destination = Integer.parseInt(tokens[2]);

            if (weighted) {
                int weight = Integer.parseInt(tokens[3]);
                builder.addEdge(source, destination, weight);
            } else {
                builder.addEdge(source, destination);
            }
        }


        return builder.build();
    }
}
