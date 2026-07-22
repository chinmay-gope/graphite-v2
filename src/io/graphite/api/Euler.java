package io.graphite.api;

import io.graphite.algorithm.euler.Hierholzer;
import io.graphite.api.internal.GraphAPI;
import io.graphite.graph.IGraph;
import io.graphite.result.EulerResult;

/**
 * Provides Euler path and circuit algorithms.
 *
 * <p>The {@code Euler} service determines whether a graph contains an
 * Euler path or Euler circuit and constructs one when it exists.</p>
 *
 * <pre>{@code
 * EulerResult result =
 *         graph.euler().findEulerCircuit();
 * }</pre>
 *
 * <h2>Typical Applications</h2>
 * <ul>
 *     <li>Route planning</li>
 *     <li>Chinese Postman Problem</li>
 *     <li>Network traversal</li>
 *     <li>Circuit design</li>
 * </ul>
 *
 * @author Chinmay
 * @version 2.0
 * @see Hierholzer
 * @see EulerResult
 * @see IGraph#euler()
 * @since 2.0
 */
public final class Euler extends GraphAPI {

    public Euler(IGraph graph) {
        super(graph);
    }

    public EulerResult path() {
        return  Hierholzer.INSTANCE.findEulerPath(graph);
    }

    public EulerResult circuit() {
        return  Hierholzer.INSTANCE.findEulerCircuit(graph);
    }
}
