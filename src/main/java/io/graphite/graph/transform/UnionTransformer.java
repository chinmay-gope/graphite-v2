package io.graphite.graph.transform;

import io.graphite.builder.GraphConfiguration;
import io.graphite.graph.GraphFactory;
import io.graphite.graph.IGraph;

public final class UnionTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        GraphConfiguration config = configuration(first);
        config.setVertices(Math.max(first.vertexCount(), second.vertexCount()));

        IGraph union = GraphFactory.create(config);

        copyEdges(union, first, edge -> true);
        copyEdges(union, second,
                edge -> !union.hasEdge(edge.source(), edge.destination()));

        return union;
    }
}
