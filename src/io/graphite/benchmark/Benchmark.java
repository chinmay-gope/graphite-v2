package io.graphite.benchmark;

import io.graphite.graph.IGraph;
import io.graphite.result.BenchmarkResult;

public final class Benchmark {

    private final String name;
    private final IGraph graph;
    private final BenchmarkTask task;
    private final BenchmarkConfig configuration;


    Benchmark(String name, IGraph graph, BenchmarkTask task, BenchmarkConfig configuration) {
        this.name = name;
        this.graph = graph;
        this.task = task;
        this.configuration = configuration;
    }

    public BenchmarkResult run() {
        return BenchmarkRunner.run(
                name,
                graph,
                task,
                configuration
        );
    }

    public static BenchmarkBuilder builder() {
        return new BenchmarkBuilder();
    }
}
