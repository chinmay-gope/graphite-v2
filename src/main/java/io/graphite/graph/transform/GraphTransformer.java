package main.java.io.graphite.graph.transform;

import main.java.io.graphite.builder.GraphConfiguration;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.model.Edge;
import main.java.io.graphite.validation.GraphPreconditions;

import java.util.function.Predicate;

public abstract class GraphTransformer {

    protected final void validate(IGraph graph) {
        GraphPreconditions.requireGraph(graph);
    }

    protected void validate(IGraph first,
                            IGraph second) {
        GraphPreconditions.requireGraph(first);
        GraphPreconditions.requireGraph(second);
    }

    protected final GraphConfiguration configuration(IGraph graph) {

        GraphConfiguration configuration = new GraphConfiguration();

        configuration.setDirected(graph.isDirected());
        configuration.setWeighted(graph.isWeighted());

        return configuration;
    }

    protected void addEdge(IGraph destination, Edge edge, boolean weighted) {
        if (weighted) {
            destination.addEdge(edge.source(), edge.destination(), edge.weight());
        } else {
            destination.addEdge(edge.source(), edge.destination());
        }
    }

    protected void copyEdges(IGraph destination, IGraph source, Predicate<Edge> filter) {
        for (Edge edge : source.edges()) {
            if (filter.test(edge)) {
                addEdge(destination, edge, source.isWeighted());
            }
        }
    }

}
