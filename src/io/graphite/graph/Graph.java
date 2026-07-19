package io.graphite.graph;

import io.graphite.api.*;
import io.graphite.api.analysis.GraphAnalysis;
import io.graphite.api.analysis.GraphAnalysisService;
import io.graphite.api.io.GraphWriterService;
import io.graphite.builder.GraphConfiguration;
import io.graphite.exception.graph.InvalidVertexException;
import io.graphite.graph.internal.ImmutableGraph;
import io.graphite.model.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class Graph implements IGraph {

    private GraphWriterService writer;

    @Override
    public GraphWriterService write() {

        if (writer == null) {
            writer = new GraphWriterService(this);
        }

        return writer;
    }

    // ==========================================================
    // Fields
    // ==========================================================

    protected int edgeCount;

    protected final List<List<Edge>> adjacencyList;

    protected final GraphConfiguration configuration;

    // ==========================================================
    // Constructor
    // ==========================================================

    protected Graph(GraphConfiguration configuration) {
        this.configuration = configuration;

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < configuration.getVertices(); i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // ==========================================================
    // Internal Helpers
    // ==========================================================

    protected GraphConfiguration configuration() {
        return configuration;
    }

    // ==========================================================
    // Validation
    // ==========================================================

    protected void validateVertex(int vertex) {

        if (!containsVertex(vertex)) {
            throw new InvalidVertexException(vertex);
        }
    }

    // ==========================================================
    // Queries
    // ==========================================================

    @Override
    public boolean containsVertex(int vertex) {
        return vertex >= 0 && vertex < configuration.getVertices();
    }

    @Override
    public int degree(int vertex) {

        validateVertex(vertex);

        return adjacencyList.get(vertex).size();
    }

    @Override
    public boolean hasEdge(int source, int destination) {

        validateVertex(source);
        validateVertex(destination);

        return adjacencyList.get(source).stream().anyMatch(edge -> edge.destination() == destination);
    }

    // ==========================================================
    // Views
    // ==========================================================

    @Override
    public List<Edge> getNeighbors(int vertex) {

        validateVertex(vertex);

        return Collections.unmodifiableList(adjacencyList.get(vertex));
    }

    @Override
    public List<Edge> getEdges() {

        List<Edge> edges = new ArrayList<>();

        for (List<Edge> neighbours : adjacencyList) {
            edges.addAll(neighbours);
        }

        return List.copyOf(edges);
    }

    // ==========================================================
    // Metadata
    // ==========================================================

    @Override
    public int getVertices() {
        return configuration.getVertices();
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public boolean isWeighted() {
        return configuration.isWeighted();
    }

    @Override
    public boolean isEmpty() {
        return configuration.getVertices() == 0;
    }

    @Override
    public boolean isDirected() {
        return configuration.isDirected();
    }

    @Override
    public boolean isUndirected() {
        return configuration.isUndirected();
    }


    // ==========================================================
    // Mutation
    // ==========================================================

    @Override
    public void clear() {

        adjacencyList.forEach(List::clear);

        edgeCount = 0;
    }

    @Override
    public IGraph asImmutable() {
        return new ImmutableGraph(this);
    }

    // ==========================================================
    // Abstract
    // ==========================================================

    @Override
    public abstract void addEdge(int source, int destination, int weight);

    @Override
    public abstract void removeEdge(int source, int destination);

    @Override
    public IGraph copy() {
        return GraphCopier.copy(this);
    }

    @Override
    public IGraph transpose() {
        return GraphTransposer.transpose(this);
    }

    // ==========================================================
    // Aliases
    // ==========================================================

    @Override
    public List<Edge> neighbors(int vertex) {
        return getNeighbors(vertex);
    }

    @Override
    public List<Edge> edges() {
        return getEdges();
    }

    @Override
    public int vertexCount() {
        return getVertices();
    }

    @Override
    public boolean contains(int vertex) {
        return containsVertex(vertex);
    }

    @Override
    public Iterable<Integer> vertices() {

        List<Integer> vertices = new ArrayList<>();

        for (int i = 0; i < getVertices(); i++) {
            vertices.add(i);
        }

        return Collections.unmodifiableList(vertices);
    }

    // ==========================================================
    // Services
    // ==========================================================

    private TraversalService traversal;
    private MSTService mst;
    private ShortestPathService shortestPath;
    private ConnectivityService connectivity;
    private CycleService cycle;
    private EulerService euler;
    private TopologyService topology;
    private BipartiteService bipartite;

    private GraphAnalysis analysis;

    @Override
    public TraversalService traversal() {

        if (traversal == null) {
            traversal = new TraversalService(this);
        }

        return traversal;
    }

    @Override
    public MSTService mst() {

        if (mst == null) {
            mst = new MSTService(this);
        }

        return mst;
    }

    @Override
    public ShortestPathService shortestPath() {

        if (shortestPath == null) {
            shortestPath = new ShortestPathService(this);
        }

        return shortestPath;
    }

    @Override
    public ConnectivityService connectivity() {

        if (connectivity == null) {
            connectivity = new ConnectivityService(this);
        }

        return connectivity;
    }

    @Override
    public CycleService cycle() {

        if (cycle == null) {
            cycle = new CycleService(this);
        }

        return cycle;
    }

    @Override
    public EulerService euler() {

        if (euler == null) {
            euler = new EulerService(this);
        }

        return euler;
    }

    @Override
    public TopologyService topology() {

        if (topology == null) {
            topology = new TopologyService(this);
        }

        return topology;
    }

    @Override
    public BipartiteService bipartite() {

        if (bipartite == null) {
            bipartite = new BipartiteService(this);
        }

        return bipartite;
    }

    // ==========================================================
    // Analysis
    // ==========================================================

    @Override
    public GraphAnalysis analysis() {

        if (analysis == null) {
            analysis = new GraphAnalysisService(this);
        }

        return analysis;
    }

}
