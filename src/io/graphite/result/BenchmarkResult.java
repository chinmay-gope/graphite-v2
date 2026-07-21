package io.graphite.result;

import io.graphite.graph.IGraph;

public record BenchmarkResult(
        // ---------------------------------------------------------
        // Benchmark
        // ---------------------------------------------------------
        String name,
        int warmup,
        int iterations,
        // ---------------------------------------------------------
        // Graph Information
        // ---------------------------------------------------------
        int vertices,
        int edges,
        boolean directed,
        boolean weighted,
        IGraph immutable,
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
