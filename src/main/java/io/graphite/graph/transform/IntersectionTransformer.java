package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;

public final class IntersectionTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        GraphConfiguration config = configuration(first);
        config.setVertices(Math.max(first.vertexCount(), second.vertexCount()));

        IGraph intersection = GraphFactory.create(config);

        copyEdges(intersection, first,
                edge -> second.hasEdge(edge.source(), edge.destination()));

        return intersection;
    }
}
