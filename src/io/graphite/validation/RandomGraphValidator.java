package io.graphite.validation;

import io.graphite.builder.GraphConfiguration;
import io.graphite.exception.graph.InvalidGraphConfigurationException;

public final class RandomGraphValidator {
    private RandomGraphValidator() {
    }

    public static void validate(GraphConfiguration configuration) {
        if (configuration.getVertices() <= 0) {
            throw new InvalidGraphConfigurationException("Vertices must be greater than zero.");
        }

        if (configuration.getEdges() <= 0) {
            throw new InvalidGraphConfigurationException("Edges cannot be negative.");
        }

        if (configuration.isWeighted() && configuration.getMinWeight() > configuration.getMaxWeight()) {

            throw new InvalidGraphConfigurationException("Minimum weight cannot exceed maximum weight.");
        }

        if (configuration.isConnected() && configuration.getEdges() < configuration.getVertices() - 1) {

            throw new InvalidGraphConfigurationException("A connected graph requires at least V - 1 edges.");
        }

        if (!configuration.allowParallelEdges() && configuration.getEdges() > maximumEdges(configuration)) {

            throw new InvalidGraphConfigurationException("Too many edges requested.");
        }
    }

    private static int maximumEdges(GraphConfiguration configuration) {

        if (configuration.isDirected()) {

            return configuration.allowsSelfLoops()
                    ? configuration.getVertices() * configuration.getVertices() // v ^ 2
                    : configuration.getVertices() * (configuration.getVertices() - 1); // v * (v - 1)
        }

        int max = configuration.getVertices()
                * (configuration.getVertices() - 1) / 2; // v * (v - 1) / 2

        return configuration.allowsSelfLoops()
                ? max + configuration.getVertices()
                : max;
    }
}
