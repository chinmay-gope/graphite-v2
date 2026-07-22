package main.java.io.graphite.validation;

import main.java.io.graphite.exception.graph.InvalidGraphConfigurationException;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.result.EulerResult;

import java.util.List;

public final class EulerValidator {
    private EulerValidator() {
    }

    public static void validate(
            IGraph graph,
            EulerResult result) {

        validateLength(graph, result);
        validateEdgesExist(graph, result);
        validateEulerType(result);
    }

    private static void validateEulerType(EulerResult result) {
        List<Integer> traversal = result.traversal();

        int first = traversal.getFirst();
        int last = traversal.getLast();

        switch (result.type()) {

            case CIRCUIT -> {
                if (first != last) {
                    throw new InvalidGraphConfigurationException(
                            "Euler circuit must start and end at the same vertex."
                    );
                }
            }

            case PATH -> {
                if (first == last) {
                    throw new InvalidGraphConfigurationException(
                            "Euler path must start and end at different vertices."
                    );
                }
            }
        }
    }

    private static void validateLength(
            IGraph graph,
            EulerResult result) {

        int expected = graph.edgeCount() + 1;
        int actual = result.traversal().size();

        if (actual != expected) {
            throw new InvalidGraphConfigurationException(
                    "Expected traversal length " + expected +
                            " but found " + actual
            );
        }
    }

    private static void validateEdgesExist(
            IGraph graph,
            EulerResult result) {

        List<Integer> path = result.traversal();

        for (int i = 0; i < path.size() - 1; i++) {

            int u = path.get(i);
            int v = path.get(i + 1);

            if (!graph.hasEdge(u, v)) {
                throw new InvalidGraphConfigurationException(
                        "Edge " + u + " -> " + v + " does not exist."
                );
            }
        }
    }
}
