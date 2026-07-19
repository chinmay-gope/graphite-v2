package io.graphite.builder;


import io.graphite.exception.graph.InvalidGraphConfigurationException;

public final class BuilderValidator {
    private BuilderValidator() {
        throw new AssertionError("Utility class");
    }

    public static void validate(GraphConfiguration configuration) {
        if (configuration.getVertices() <= 0) {
            throw new InvalidGraphConfigurationException("Vertices must be greater than zero.");
        }

        if (configuration.getMinWeight() > configuration.getMaxWeight()) {
            throw new InvalidGraphConfigurationException("Minimum weight must be cannot exceed maximum weight.");
        }
    }
}
