package io.graphite.benchmark.algorithm;

public final class BenchmarkTestRunner {
    private BenchmarkTestRunner() {
    }

    static void main(String[] args) {
        TraversalBenchmark.run();
        CycleBenchmark.run();
        MSTBenchmark.run();
        ShortestPathBenchmark.run();
        ConnectivityBenchmark.run();
        TopologyBenchmark.run();
        BipartiteBenchmark.run();
        EulerBenchmark.run();
    }
}
