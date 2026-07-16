package io.graphite.algorithm.generator;

import io.graphite.algorithm.graph.GraphType;
import io.graphite.algorithm.graph.Graph;
import io.graphite.algorithm.builder.GraphBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility for generating random graphs using a fluent builder API.
 * <p>
 * Supports:
 * <ul>
 *   <li>Directed and undirected graphs</li>
 *   <li>Weighted and unweighted edges</li>
 *   <li>Connected graph generation</li>
 *   <li>Self-loops</li>
 *   <li>Parallel edges</li>
 * </ul>
 */
public final class RandomGraphGenerator {

    private final GraphType graphType;

    private int vertices;
    private int edges;

    private boolean weighted;

    private int minWeight = 1;
    private int maxWeight = 10;

    private boolean connected;
    private boolean allowSelfLoops;
    private boolean allowParallelEdges;

    private ThreadLocalRandom random() {
        return ThreadLocalRandom.current();
    }

    private final Set<EdgeKey> usedEdges = new HashSet<>();

    private RandomGraphGenerator(GraphType graphType) {
        this.graphType = graphType;
    }


    private void generateSpanningTree(GraphBuilder builder) {

        for (int vertex = 1; vertex < vertices; vertex++) {

            int parent = random().nextInt(vertex);

            addEdge(builder, parent, vertex);
        }
    }

    private boolean isSelfLoop(int source, int destination) {
        return source == destination;
    }

    private int randomVertex() {
        return random().nextInt(vertices);
    }

    private int randomWeight() {
        return random().nextInt(minWeight, maxWeight + 1);
    }

    private void addEdge(GraphBuilder builder, int source, int destination) {

        int weight = randomWeight();

        if (weighted) {
            builder.addEdge(source, destination, weight);
        } else {
            builder.addEdge(source, destination);
        }

        rememberEdge(source, destination);
    }

    private void rememberEdge(int source, int destination) {

        usedEdges.add(createEdgeKey(source, destination));
    }

    private boolean edgeExists(int source, int destination) {
        return usedEdges.contains(createEdgeKey(source, destination));
    }

    private EdgeKey createEdgeKey(int source, int destination) {

        if (graphType == GraphType.UNDIRECTED) {

            return new EdgeKey(
                    Math.min(source, destination),
                    Math.max(source, destination));
        }

        return new EdgeKey(source, destination);
    }


    private void generateRemainingEdges(GraphBuilder builder) {

        while (usedEdges.size() < edges) {

            int source = randomVertex();
            int destination = randomVertex();

            if (!allowSelfLoops && isSelfLoop(source, destination)) {
                continue;
            }

            if (!allowParallelEdges && edgeExists(source, destination)) {
                continue;
            }

            addEdge(builder, source, destination);
        }
    }

    private int getMaximumEdges() {

        if (graphType == GraphType.DIRECTED) {

            return allowSelfLoops ? vertices * vertices : vertices * (vertices - 1);
        }

        int maximumEdges = vertices * (vertices - 1) / 2;

        return allowSelfLoops ? maximumEdges + vertices : maximumEdges;
    }

    private GraphBuilder createBuilder() {

        return graphType == GraphType.DIRECTED ? GraphBuilder.directed(vertices) : GraphBuilder.undirected(vertices);
    }

    public static RandomGraphGenerator directed() {
        return new RandomGraphGenerator(GraphType.DIRECTED);
    }

    public static RandomGraphGenerator undirected() {
        return new RandomGraphGenerator(GraphType.UNDIRECTED);
    }

    public Graph build() {

        validate();

        GraphBuilder builder = createBuilder();


        if (connected) {
            generateSpanningTree(builder);
        }

        generateRemainingEdges(builder);

        return builder.build();
    }

    public RandomGraphGenerator vertices(int vertices) {
        this.vertices = vertices;
        return this;
    }

    public RandomGraphGenerator edges(int edges) {
        this.edges = edges;
        return this;
    }

    public RandomGraphGenerator connected(boolean connected) {
        this.connected = connected;
        return this;
    }

    public RandomGraphGenerator weighted(boolean weighted) {
        this.weighted = weighted;
        return this;
    }

    public RandomGraphGenerator weightRange(int minWeight, int maxWeight) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        return this;
    }

    public RandomGraphGenerator allowSelfLoops(boolean allowSelfLoops) {
        this.allowSelfLoops = allowSelfLoops;
        return this;
    }

    public RandomGraphGenerator allowParallelEdges(boolean allowParallelEdges) {
        this.allowParallelEdges = allowParallelEdges;
        return this;
    }

    public static Graph dag(int vertices) {

        GraphBuilder builder = GraphBuilder.directed(vertices);

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int maxEdges = vertices * (vertices - 1) / 2;
        int edges = Math.min(vertices * 2, maxEdges);

        Set<String> usedEdges = new HashSet<>();

        while (usedEdges.size() < edges) {

            int source = random.nextInt(vertices - 1);
            int destination = random.nextInt(source + 1, vertices);

            String key = source + "-" + destination;

            if (usedEdges.add(key)) {
                builder.addEdge(source, destination, random.nextInt(1, 51));
            }
        }

        return builder.build();
    }

    public static Graph bipartiteGraph(int vertices) {

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int leftSize = vertices / 2;

        Set<String> used = new HashSet<>();

        int edges = vertices * 2;

        while (used.size() < edges) {

            int source = random.nextInt(leftSize);

            int destination = random.nextInt(leftSize, vertices);

            String key = source + "-" + destination;

            if (used.add(key)) {
                builder.addEdge(source, destination);
            }
        }

        return builder.build();
    }

    private void validate() {

        if (vertices <= 0) {
            throw new IllegalArgumentException("Vertices must be greater than zero.");
        }

        if (edges < 0) {
            throw new IllegalArgumentException("Edges cannot be negative.");
        }

        if (weighted && minWeight > maxWeight) {
            throw new IllegalArgumentException("Minimum weight cannot exceed maximum weight.");
        }

        if (connected && edges < vertices - 1) {
            throw new IllegalArgumentException("A connected graph requires at least vertices - 1 edges.");
        }

        if (!allowParallelEdges && edges > getMaximumEdges()) {
            throw new IllegalArgumentException("Too many edges requested for the given graph configuration.");
        }
    }

    private record EdgeKey(int source, int destination) {
    }
}
