package io.graphite.algorithm.result;

import java.util.List;

public record APResult(List<Integer> articulationPoints) {

    public APResult {
        articulationPoints = List.copyOf(articulationPoints);
    }

    @Override
    public List<Integer> articulationPoints() {
        return List.copyOf(articulationPoints);
    }

    @Override
    public String toString() {
        return Result.CYAN + "Articulation Points: " + Result.RESET +
                Result.MAGENTA + articulationPoints + Result.RESET;
    }
}
