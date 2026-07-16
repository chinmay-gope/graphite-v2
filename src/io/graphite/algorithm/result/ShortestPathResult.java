package io.graphite.algorithm.result;

import java.util.Objects;

public record ShortestPathResult(int source, int[] distance) {

    public ShortestPathResult {
        Objects.requireNonNull(distance, "distance cannot be null");
        distance = distance.clone();
    }

    @Override
    public int[] distance() {
        return distance.clone();
    }

    @Override
    public String toString() {
//        return "ShortestPathResult{" + "source=" + source + ", distance=" + Arrays.toString(distance) + '}';

        StringBuilder builder = new StringBuilder();

        builder.append("Source Vertex: ")
                .append(source)
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        for (int i = 0; i < distance.length; i++) {
            builder.append(i)
                    .append(" -> ");

            if (distance[i] == Integer.MAX_VALUE) {
                builder.append("INF");
            } else {
                builder.append(distance[i]);
            }

            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
