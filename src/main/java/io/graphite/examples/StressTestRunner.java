package main.java.io.graphite.examples;

import main.java.graphite.benchmark.stress.*;
import main.java.io.graphite.benchmark.stress.*;

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
