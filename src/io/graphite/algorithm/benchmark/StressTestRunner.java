package io.graphite.algorithm.benchmark;

import io.graphite.algorithm.benchmark.bipartite.BipartiteBenchmark;
import io.graphite.algorithm.benchmark.connectivity.ConnectivityBenchmark;
import io.graphite.algorithm.benchmark.cycle.CycleBenchmark;
import io.graphite.algorithm.benchmark.euler.EulerBenchmark;
import io.graphite.algorithm.benchmark.mst.MSTBenchmark;
import io.graphite.algorithm.benchmark.shortestpath.ShortestPathBenchmark;
import io.graphite.algorithm.benchmark.topology.TopologyBenchmark;
import io.graphite.algorithm.benchmark.traversal.TraversalBenchmark;

public class StressTestRunner {

    private StressTestRunner() {
    }

    static void main() {
        executeThemAll();
    }


    static void executeThemAll() {
        TraversalBenchmark.stressBFS();
        TraversalBenchmark.stressDFS();

        // both dir & un-dir
        CycleBenchmark.stressCycleDetection();

        MSTBenchmark.stressPrim();
        MSTBenchmark.stressKruskal();

        ShortestPathBenchmark.stressDijkstra();
        ShortestPathBenchmark.stressBellmanFord();
        ShortestPathBenchmark.stressTestFloydWarshall();

        TopologyBenchmark.stressTestTopo();
        // both bfs & dfs
        BipartiteBenchmark.stressBipartite();

        //  sparse, traversal, mst, dense
        ConnectivityBenchmark.stressBiConnected();
        ConnectivityBenchmark.stressBridges();
        ConnectivityBenchmark.stressSCCs();
        ConnectivityBenchmark.stressAP();

        // Euler circuit & path
        EulerBenchmark.stressEulerPath();
        EulerBenchmark.stressEulerCircuit();
        EulerBenchmark.stressInvalidEulerGraph();
        EulerBenchmark.stressDisconnectedEulerGraph();
    }
}
