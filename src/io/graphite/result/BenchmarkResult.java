package io.graphite.result;

/**
 * Represents the outcome of a benchmark execution.
 *
 * <p>A {@code BenchmarkResult} stores execution statistics collected during
 * repeated benchmark iterations.</p>
 *
 * <h2>
 * Contents
 * </h2>
 *
 * <ul>
 *     <li>Average execution time</li>
 *     <li>Minimum execution time</li>
 *     <li>Maximum execution time</li>
 *     <li>Iteration count</li>
 * </ul>
 *
 * @author Chinmay
 * @since 2.0
 * @version 2.0
 *
 * @see io.graphite.benchmark.Benchmark
 * @see io.graphite.benchmark.BenchmarkRunner
 */
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
