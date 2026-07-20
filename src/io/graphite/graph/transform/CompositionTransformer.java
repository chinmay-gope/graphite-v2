package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class CompositionTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        int vertices = Math.max(first.vertexCount(), second.vertexCount());

        GraphConfiguration config = configuration(first);
        config.setVertices(vertices);

        IGraph composition = GraphFactory.create(config);

        // Build adjacency matrices
        int[][] A = buildMatrix(first, vertices);
        int[][] B = buildMatrix(second, vertices);

        // Matrix multiplication
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                int weight = 0;
                for (int k = 0; k < vertices; k++) {
                    weight += A[i][k] * B[k][j];
                }
                if (weight > 0) {
                    if (first.isWeighted() || second.isWeighted()) {
                        composition.addEdge(i, j, weight);
                    } else {
                        composition.addEdge(i, j);
                    }
                }
            }
        }

        return composition;
    }

    private int[][] buildMatrix(IGraph graph, int vertices) {
        int[][] matrix = new int[vertices][vertices];
        for (Edge edge : graph.edges()) {
            matrix[edge.source()][edge.destination()] =
                    graph.isWeighted() ? edge.weight() : 1;
        }
        return matrix;
    }
}
