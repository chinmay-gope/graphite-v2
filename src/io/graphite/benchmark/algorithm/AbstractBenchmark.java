package io.graphite.benchmark.algorithm;

import io.graphite.benchmark.Benchmark;
import io.graphite.benchmark.BenchmarkPrinter;
import io.graphite.benchmark.BenchmarkTask;
import io.graphite.graph.IGraph;
import io.graphite.result.BenchmarkResult;

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

//        System.out.println(result);
        BenchmarkPrinter.print(result);

        return result;
    }
}
