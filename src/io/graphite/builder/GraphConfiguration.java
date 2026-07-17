package io.graphite.builder;

public final class GraphConfiguration {
    private int vertices;

    private boolean weighted;

    private int minWeight = 1;
    private int maxWeight = 10;

    private boolean selfLoops;
    private boolean immutable;

    private boolean parallelEdges;

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
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

    public boolean isSelfLoops() {
        return selfLoops;
    }

    public void setSelfLoops(boolean selfLoops) {
        this.selfLoops = selfLoops;
    }

    public boolean isImmutable() {
        return immutable;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = immutable;
    }

    public boolean isParallelEdges() {
        return parallelEdges;
    }

    public void setParallelEdges(boolean parallelEdges) {
        this.parallelEdges = parallelEdges;
    }
}
