package io.graphite.algorithm;

import io.graphite.algorithm.exception.graph.UnsupportedGraphTypeException;
import io.graphite.algorithm.graph.GraphType;
import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.model.GraphEdge;
import io.graphite.algorithm.validation.GraphValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class GraphAlgorithm {

    protected void validateGraph(IGraph graph) {
        Objects.requireNonNull(graph, "Graph cannot be null.");
    }

    protected void validateVertex(IGraph graph, int vertex) {
        GraphValidator.validateVertex(graph, vertex);
    }

    protected boolean[] createVisitedArray(IGraph graph) {
        return new boolean[graph.getVertices()];
    }

    protected int[] createDistanceArray(IGraph graph, int initialValue) {
        int[] distance = new int[graph.getVertices()];
        Arrays.fill(distance, initialValue);
        return distance;
    }

    protected int[][] createDistanceMatrix(IGraph graph) {
        int V = graph.getVertices();
        int[][] distance = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;

            for (Edge edge : neighbours(graph, i)) {
                distance[i][edge.destination()] = edge.weight();
            }
        }
        return distance;
    }

    protected List<Integer> createTraversalList() {
        return new ArrayList<>();
    }

    protected void requireDirectedGraph(IGraph graph) {
        if (graph.getGraphType() != GraphType.DIRECTED) {
            throw new UnsupportedGraphTypeException(GraphType.DIRECTED, graph.getGraphType());
        }
    }

    protected void requireUndirectedGraph(IGraph graph) {
        if (graph.getGraphType() != GraphType.UNDIRECTED) {
            throw new UnsupportedGraphTypeException(GraphType.UNDIRECTED, graph.getGraphType());
        }
    }

    protected Iterable<Edge> neighbours(IGraph graph, int vertex) {
        return graph.getNeighbours(vertex);
    }

    protected List<GraphEdge> getAllEdges(IGraph graph) {
        List<GraphEdge> edges = new ArrayList<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : neighbours(graph, i)) {

                // Skip duplicate edges in undirected graphs.
                if (graph.getGraphType() == GraphType.UNDIRECTED && i > edge.destination()) {
                    continue;
                }

                edges.add(new GraphEdge(
                        i,
                        edge.destination(),
                        edge.weight()
                ));
            }
        }
        return edges;
    }
}
