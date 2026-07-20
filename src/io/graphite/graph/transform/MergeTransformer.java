package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class MergeTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        GraphConfiguration config = configuration(first);

        int vertices = Math.max(
                first.vertexCount(),
                second.vertexCount()
        );

        config.setVertices(vertices);

        IGraph merged = GraphFactory.create(config);

        addEdges(merged, first);
        addEdges(merged, second);

        return merged;
    }

    private void addEdges(IGraph destination, IGraph source) {
        for (Edge edge : source.edges()) {
            if (source.isWeighted()) {

                destination.addEdge(
                        edge.source(),
                        edge.destination(),
                        edge.weight()
                );
            } else {
                destination.addEdge(
                        edge.source(),
                        edge.destination()
                );
            }
        }
    }

}
