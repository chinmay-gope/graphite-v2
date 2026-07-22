package io.graphite.exception.graph;

import io.graphite.builder.GraphConfiguration;
import io.graphite.exception.GraphException;
import io.graphite.validation.BuilderValidator;

/**
 * Thrown when a graph configuration contains invalid or inconsistent
 * parameters.
 *
 * <p>This exception is typically raised during graph construction when
 * configuration values such as the number of vertices, edges, or weight
 * ranges violate the required constraints.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphConfiguration
 * @see BuilderValidator
 * @since 2.0
 */
public class InvalidGraphConfigurationException extends GraphException {
    public InvalidGraphConfigurationException(String message) {
        super(message);
    }
}
