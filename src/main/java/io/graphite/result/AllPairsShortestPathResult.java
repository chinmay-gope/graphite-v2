package main.java.io.graphite.result;

import java.util.Arrays;

public record AllPairsShortestPathResult(int[][] distance) implements Colors {
    public AllPairsShortestPathResult {
        distance = Arrays.stream(distance)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public int distance(int source, int destination) {
        return distance[source][destination];
    }

    public boolean isReachable(int source, int destination) {
        return distance[source][destination] != Integer.MAX_VALUE;
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
