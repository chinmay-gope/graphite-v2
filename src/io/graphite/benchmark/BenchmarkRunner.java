package io.graphite.benchmark;

import io.graphite.result.BenchmarkResult;

public final class BenchmarkRunner {

    private BenchmarkRunner() {
    }

    public static BenchmarkResult run(
            String name,
            BenchmarkTask task,
            BenchmarkConfig config
    ) {

        // ---------------------------------------------------------
        // Warmup
        // ---------------------------------------------------------

        for (int i = 0; i < config.warmup(); i++) {
            task.execute();
        }

        // ---------------------------------------------------------
        // Benchmark
        // ---------------------------------------------------------

        double[] times = new double[config.iterations()];
        long totalNanos = 0;

        for (int i = 0; i < config.iterations(); i++) {

            long start = System.nanoTime();

            task.execute();

            long end = System.nanoTime();

            long elapsed = end - start;

            totalNanos += elapsed;

            times[i] = (end - start) / 1_000_000.0;
        }

        // ---------------------------------------------------------
        // Statistics
        // ---------------------------------------------------------

        double average = BenchmarkStatistics.average(times);
        double minimum = BenchmarkStatistics.minimum(times);
        double maximum = BenchmarkStatistics.maximum(times);
        double deviation = BenchmarkStatistics.standardDeviation(times);

        double operationsPerSecond =
                config.iterations() / (totalNanos / 1_000_000_000.0);

        double totalMillis = totalNanos / 1_000_000.0;

        return new BenchmarkResult(
                name,
                config.warmup(),
                config.iterations(),
                totalMillis,
                average,
                minimum,
                maximum,
                deviation,
                operationsPerSecond
        );
    }
}
