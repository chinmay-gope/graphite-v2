package io.graphite.algorithm.model;

public record Edge(int destination, int weight) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge(int dest, int wt))) return false;

        return destination == dest && weight == wt;
    }

    @Override
    public String toString() {
        return "(" + destination + ", " + weight + ")";
    }
}
