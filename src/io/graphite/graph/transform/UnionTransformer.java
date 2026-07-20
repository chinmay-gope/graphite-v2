package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class UnionTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        GraphConfiguration config = configuration(first);

        int vertices = Math.max(
                first.vertexCount(),
                second.vertexCount()
        );

        config.setVertices(vertices);

        IGraph union = GraphFactory.create(config);

        addUniqueEdges(union, first);
        addUniqueEdges(union, second);

        return union;
    }

    private void addUniqueEdges(IGraph destination, IGraph source) {
        for (Edge edge : source.edges()) {
            if (source.isWeighted()) {
                if (destination.hasEdge(edge.source(),
                        edge.destination())) {
                    continue;
                }

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
