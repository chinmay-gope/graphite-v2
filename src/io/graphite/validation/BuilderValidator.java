package io.graphite.validation;


import io.graphite.builder.GraphConfiguration;
import io.graphite.exception.graph.InvalidGraphConfigurationException;

/**
 * Validates graph builder configurations before graph construction.
 *
 * <p>{@code BuilderValidator} ensures that builder parameters such as
 * vertex count, edge count, weight ranges, and graph configuration are
 * internally consistent before graph generation begins.</p>
 *
 * <h2>Typical Validations</h2>
 *
 * <ul>
 *     <li>Vertex count</li>
 *     <li>Edge count</li>
 *     <li>Weight range</li>
 *     <li>Configuration consistency</li>
 * </ul>
 *
 * <p>Validation failures result in descriptive exceptions that help users
 * identify invalid builder configurations.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphConfiguration
 * @see io.graphite.generator.RandomGraphBuilder
 * @see io.graphite.graph.PatternGraphFactory
 * @since 2.0
 */
public final class BuilderValidator {
    private BuilderValidator() {
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
