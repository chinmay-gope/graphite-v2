package io.graphite.result;

import java.util.Arrays;

import static io.graphite.result.Result.*;

public record AllPairsShortestPathResult(int[][] distance) implements Result {
    public AllPairsShortestPathResult {
        distance = Arrays.stream(distance)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    @Override
    public int[][] distance() {
        return Arrays.stream(distance)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        System.out.println();
        for (int[] row : distance) {
            for (int value : row) {
                if (value == Integer.MAX_VALUE) {
                    builder.append(RED).append("INF").append(RESET).append('\t');
                } else if (value == 0) {
                    builder.append(CYAN).append(value).append(RESET).append('\t');
                } else if (value > 0) {
                    builder.append(GREEN).append(value).append(RESET).append('\t');
                } else {
                    builder.append(MAGENTA).append(value).append(RESET).append('\t');
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
