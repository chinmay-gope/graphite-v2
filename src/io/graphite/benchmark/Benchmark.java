package io.graphite.benchmark;

import io.graphite.builder.BenchmarkBuilder;
import io.graphite.result.BenchmarkResult;

public final class Benchmark {

    private final String name;
    private final BenchmarkTask task;
    private final BenchmarkConfig configuration;


    public Benchmark(String name, BenchmarkTask task, BenchmarkConfig configuration) {
        this.name = name;
        this.task = task;
        this.configuration = configuration;
    }

    public BenchmarkResult run() {
        return BenchmarkRunner.run(
                name,
                task,
                configuration
        );
    }

    public static BenchmarkBuilder builder() {
        return new BenchmarkBuilder();
    }
}
