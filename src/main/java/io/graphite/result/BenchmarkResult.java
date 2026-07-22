package main.java.io.graphite.result;

import main.java.io.graphite.benchmark.Benchmark;
import main.java.io.graphite.benchmark.BenchmarkRunner;

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
 * @version 2.0
 * @see Benchmark
 * @see BenchmarkRunner
 * @since 2.0
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
