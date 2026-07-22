package main.java.io.graphite.examples;

import main.java.graphite.benchmark.algorithm.*;
import main.java.io.graphite.benchmark.algorithm.*;

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
