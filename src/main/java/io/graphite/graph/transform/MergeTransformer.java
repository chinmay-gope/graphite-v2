package main.java.io.graphite.graph.transform;

import main.java.io.graphite.builder.GraphConfiguration;
import main.java.io.graphite.graph.GraphFactory;
import main.java.io.graphite.graph.IGraph;

public final class MergeTransformer extends GraphTransformer {

    public IGraph transform(IGraph first, IGraph second) {
        validate(first, second);

        GraphConfiguration config = configuration(first);
        config.setVertices(Math.max(first.vertexCount(), second.vertexCount()));

        IGraph merged = GraphFactory.create(config);

        copyEdges(merged, first, edge -> true);
        copyEdges(merged, second, edge -> true);

        return merged;
    }
}
