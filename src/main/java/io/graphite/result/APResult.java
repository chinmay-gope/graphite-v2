package io.graphite.result;

import java.util.List;

public record APResult(List<Integer> articulationPoints) implements Colors {

    public APResult {
        articulationPoints = List.copyOf(articulationPoints);
    }

    public boolean contains(int vertex) {
        return articulationPoints.contains(vertex);
    }

    public int count() {
        return articulationPoints.size();
    }

    public boolean isEmpty() {
        return articulationPoints.isEmpty();
    }

    @Override
    public List<Integer> articulationPoints() {
        return List.copyOf(articulationPoints);
    }

    @Override
    public String toString() {
        return CYAN + "Articulation Points: " + RESET +
                MAGENTA + articulationPoints + RESET;
    }
}
