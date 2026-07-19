package io.graphite.api;

import io.graphite.algorithm.connectivity.APFinder;
import io.graphite.algorithm.connectivity.BiconnectedComponents;
import io.graphite.algorithm.connectivity.BridgeFinder;
import io.graphite.algorithm.connectivity.Kosaraju;
import io.graphite.graph.IGraph;
import io.graphite.result.APResult;
import io.graphite.result.BiConnectedResult;
import io.graphite.result.BridgeResult;
import io.graphite.result.SCCResult;

public final class ConnectivityService extends GraphService {

    public ConnectivityService(IGraph graph) {
        super(graph);
    }

    public APResult articulationPoints() {
        return new APFinder().findArticulationPoints(graph);
    }

    public BridgeResult bridges() {
        return new BridgeFinder().findBridges(graph);
    }

    public BiConnectedResult biconnectedComponents() {
        return new BiconnectedComponents().findBiconnectedComponents(graph);
    }

    public SCCResult stronglyConnectedComponents() {
        return new Kosaraju().findSCCs(graph);
    }
}
