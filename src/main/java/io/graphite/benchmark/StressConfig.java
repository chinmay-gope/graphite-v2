package io.graphite.benchmark;

public record StressConfig(int iterations, int[] vertices, int edgeMultiplier) {

    public static final StressConfig DEFAULT_CONFIG =
            new StressConfig(
                    20,
                    new int[]{10, 50, 100, 250, 500, 1000},
                    2
            );

    public static final StressConfig WEIGHTED_CONFIG =
            new StressConfig(
                    10,
                    new int[]{10, 50, 100, 250, 500},
                    4
            );

    public static final StressConfig DENSE_CONFIG =
            new StressConfig(
                    5,
                    new int[]{10, 25, 50, 75, 100, 150, 200},
                    1
            );

    public static final StressConfig FLOYD_CONFIG =
            new StressConfig(
                    5,
                    new int[]{10, 25, 50, 75, 100},
                    2
            );
}
