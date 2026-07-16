package io.graphite.algorithm.util;

import io.graphite.algorithm.graph.IGraph;
import io.graphite.algorithm.traversal.DFS;
import io.graphite.algorithm.exception.graph.UnsupportedGraphTypeException;
import io.graphite.algorithm.graph.GraphFactory;
import io.graphite.algorithm.graph.GraphType;
import io.graphite.algorithm.model.Edge;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.result.TraversalResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GraphUtils {
    private GraphUtils() {
        throw new AssertionError("No GraphUtils instances for you!");
    }

    public static int edgeCount(IGraph graph) {
        int count = 0;

        for (int i = 0; i < graph.getVertices(); i++) {
            count += graph.getNeighbours(i).size();
        }

        if (graph.getGraphType() == GraphType.UNDIRECTED) {
            count /= 2;
        }

        return count;
    }

    public static boolean hasEdge(
            IGraph graph,
            int source,
            int destination) {
        for (Edge edge : graph.getNeighbours(source)) {
            if (edge.destination() == destination) {
                return true;
            }
        }

        return false;
    }

    public static Graph transpose(IGraph graph) {
        if (graph.getGraphType() != GraphType.DIRECTED) {
            throw new UnsupportedGraphTypeException(graph.getGraphType(), GraphType.DIRECTED);
        }
        Graph reversed = GraphFactory.create(
                GraphType.DIRECTED,
                graph.getVertices()
        );

        for (int source = 0; source < graph.getVertices(); source++) {
            for (Edge edge : graph.getNeighbours(source)) {
                reversed.addEdge(
                        edge.destination(),
                        source,
                        edge.weight()
                );
            }
        }

        return reversed;
    }

    public static Graph cloneGraph(IGraph graph) {
        Graph clone = GraphFactory.create(
                graph.getGraphType(),
                graph.getVertices()
        );

        boolean directed = graph.getGraphType() == GraphType.DIRECTED;

        for (int source = 0; source < graph.getVertices(); source++) {
            for (Edge edge : graph.getNeighbours(source)) {
                if (directed || source < edge.destination()) {
                    clone.addEdge(
                            source,
                            edge.destination()
                            , edge.weight()
                    );
                }
            }
        }

        return clone;
    }

    public static int degree(IGraph graph, int vertex) {
        return graph.getNeighbours(vertex).size();
    }

    public static boolean isConnected(IGraph graph) {
        int start = -1;

        for (int i = 0; i < graph.getVertices(); i++) {
            if (degree(graph, i) > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return true;
        }

        TraversalResult result = new DFS().traverse(graph, start);

        Set<Integer> visited = new HashSet<>(result.traversalOrder());

        for (int i = 0; i < graph.getVertices(); i++) {

            if (degree(graph, i) > 0 && !visited.contains(i)) {
                return false;
            }
        }

        return true;
    }

    public static Edge getFirstNeighbour(IGraph graph, int vertex) {
        List<Edge> edgeList = graph.getNeighbours(vertex);

        if (edgeList.isEmpty()) {
            return null;
        }

        return edgeList.getFirst();
    }
}
