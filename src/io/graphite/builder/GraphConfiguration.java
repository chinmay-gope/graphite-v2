package io.graphite.builder;

public final class GraphConfiguration {
    private int edges;
    private int vertices;

    private boolean directed;
    private boolean connected;
    private boolean weighted;
    private boolean parallelEdges;
    private boolean selfLoops;
    private boolean immutable;

    private int minWeight = 1;
    private int maxWeight = 10;

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isUndirected() {
        return !directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public void setUndirected(boolean undirected) {
        this.directed = !undirected;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean allowsSelfLoops() {
        return selfLoops;
    }

    public void setSelfLoops(boolean selfLoops) {
        this.selfLoops = selfLoops;
    }

    public boolean allowParallelEdges() {
        return parallelEdges;
    }

    public void setParallelEdges(boolean parallelEdges) {
        this.parallelEdges = parallelEdges;
    }

    public boolean isImmutable() {
        return immutable;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = immutable;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
