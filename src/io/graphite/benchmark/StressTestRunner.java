package io.graphite.benchmark;

import io.graphite.benchmark.stress.*;

public class StressTestRunner {

    private StressTestRunner() {
    }

    static void main(String[] args) {
        TraversalStress.run();
        CycleStress.run(); // both dir & un-dir
        MSTStress.run();
        ShortestPathStress.run();
        TopologyStress.run();
        BipartiteStress.run(); // both bfs & dfs
        ConnectivityStress.run(); //  sparse, traversal, mst, dense
        EulerStress.run(); // path, circuit
    }
}
