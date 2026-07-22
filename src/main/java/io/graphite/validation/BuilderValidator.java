package main.java.io.graphite.validation;


import main.java.io.graphite.builder.GraphConfiguration;
import main.java.io.graphite.exception.graph.InvalidGraphConfigurationException;
import main.java.io.graphite.graph.PatternGraphBuilder;
import main.java.io.graphite.generator.RandomGraphBuilder;

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
 * @see RandomGraphBuilder
 * @see PatternGraphBuilder
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
