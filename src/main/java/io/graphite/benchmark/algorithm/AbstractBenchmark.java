package main.java.io.graphite.benchmark.algorithm;

import main.java.io.graphite.benchmark.Benchmark;
import main.java.io.graphite.benchmark.BenchmarkPrinter;
import main.java.io.graphite.benchmark.BenchmarkTask;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.BenchmarkResult;

/**
 * Provides common functionality for Graphite benchmark examples.
 *
 * <p>{@code AbstractBenchmark} centralizes shared benchmark configuration,
 * including default warm-up iterations, measurement iterations, and helper
 * methods for executing benchmark tasks.</p>
 *
 * <p>This class is intended as a convenience base class for benchmark
 * examples and demonstrations.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see Benchmark
 * @see BenchmarkResult
 * @since 2.0
 */
public abstract class AbstractBenchmark {

    protected static final int WARMUP = 10;
    protected static final int ITERATIONS = 100;

    protected static BenchmarkResult benchmark(
            String name,
            IGraph graph,
            BenchmarkTask task
    ) {
        BenchmarkResult result = Benchmark.builder()
                .name(name)
                .graph(graph)
                .task(task)
                .warmup(WARMUP)
                .iterations(ITERATIONS)
                .build()
                .run();

        BenchmarkPrinter.print(result);

        return result;
    }
}
