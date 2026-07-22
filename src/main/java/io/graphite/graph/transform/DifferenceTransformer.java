package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;

public final class DifferenceTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        GraphConfiguration config = configuration(first);
        config.setVertices(first.vertexCount());

        IGraph difference = GraphFactory.create(config);

        copyEdges(difference, first,
                edge -> !second.hasEdge(edge.source(), edge.destination()));

        return difference;
    }
}
