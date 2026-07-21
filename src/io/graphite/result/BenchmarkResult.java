package io.graphite.result;

public record BenchmarkResult(
        // ---------------------------------------------------------
        // Benchmark
        // ---------------------------------------------------------
        String name,
        int warmup,
        int iterations,
        // ---------------------------------------------------------
        // Performance
        // ---------------------------------------------------------
        double totalNanos,
        double averageMillis,
        double minimumMillis,
        double maximumMillis,
        double standardDeviation,
        double operationsPerSecond
) {
}
