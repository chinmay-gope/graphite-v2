package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class IntersectionTransformer extends GraphTransformer {

    public IGraph transform(IGraph first,
                            IGraph second) {

        validate(first, second);

        GraphConfiguration config = configuration(first);

        int vertices = Math.max(
                first.vertexCount(),
                second.vertexCount()
        );

        config.setVertices(vertices);

        IGraph intersection = GraphFactory.create(config);

        for (Edge edge : first.edges()) {

            if (!second.hasEdge(edge.source(),
                    edge.destination())) {
                continue;
            }

            if (first.isWeighted()) {

                intersection.addEdge(
                        edge.source(),
                        edge.destination(),
                        edge.weight());

            } else {

                intersection.addEdge(
                        edge.source(),
                        edge.destination());
            }
        }

        return intersection;
    }
}
