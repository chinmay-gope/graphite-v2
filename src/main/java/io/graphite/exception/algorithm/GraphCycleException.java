package main.java.io.graphite.exception.algorithm;

import main.java.io.graphite.exception.GraphException;
import main.java.io.graphite.algorithm.topology.DFSTopologicalSort;
import main.java.io.graphite.algorithm.topology.KahnTopologicalSort;

/**
 * Thrown when an unexpected graph cycle is encountered.
 *
 * <p>This exception is typically raised by algorithms that require an
 * acyclic graph, such as topological sorting.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see DFSTopologicalSort
 * @see KahnTopologicalSort
 * @since 2.0
 */
public class GraphCycleException extends GraphException {
    public GraphCycleException() {
        super("The graph contains one or more cycles.");
    }

    public GraphCycleException(String message) {
        super(message);
    }
}
