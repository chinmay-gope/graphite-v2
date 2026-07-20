package io.graphite.api;

import io.graphite.algorithm.connectivity.APFinder;
import io.graphite.algorithm.connectivity.BiconnectedComponents;
import io.graphite.algorithm.connectivity.BridgeFinder;
import io.graphite.algorithm.connectivity.Kosaraju;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.APResult;
import io.graphite.result.BiConnectedResult;
import io.graphite.result.BridgeResult;
import io.graphite.result.SCCResult;

public final class Connectivity extends GraphAPI {

    public Connectivity(IGraph graph) {
        super(graph);
    }

    public APResult articulationPoints() {
        return APFinder.INSTANCE.findArticulationPoints(graph);
    }

    public BridgeResult bridges() {
        return BridgeFinder.INSTANCE.findBridges(graph);
    }

    public BiConnectedResult biconnectedComponents() {
        return BiconnectedComponents.INSTANCE.findBiconnectedComponents(graph);
    }

    public SCCResult stronglyConnectedComponents() {
        return Kosaraju.INSTANCE.findSCCs(graph);
    }
}
