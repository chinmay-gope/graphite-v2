package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;

public final class DifferenceTransformer extends GraphTransformer {

    public IGraph transform(IGraph first,
                            IGraph second) {

        validate(first, second);

        GraphConfiguration config = configuration(first);

        config.setVertices(first.vertexCount());

        IGraph difference = GraphFactory.create(config);

        for (Edge edge : first.edges()) {

            if (second.hasEdge(edge.source(),
                    edge.destination())) {
                continue;
            }

            if (first.isWeighted()) {

                difference.addEdge(
                        edge.source(),
                        edge.destination(),
                        edge.weight());

            } else {

                difference.addEdge(
                        edge.source(),
                        edge.destination());
            }
        }

        return difference;
    }
}
