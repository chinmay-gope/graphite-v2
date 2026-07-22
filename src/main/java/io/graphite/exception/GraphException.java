package main.java.io.graphite.exception;

/**
 * Base class for all Graphite runtime exceptions.
 *
 * <p>{@code GraphException} represents unrecoverable errors encountered
 * during graph construction, validation, and algorithm execution. All
 * library-specific exceptions extend this class to provide a consistent
 * exception hierarchy.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @since 2.0
 */
public class GraphException extends RuntimeException {
    public GraphException(String message) {
        super(message);
    }

    public GraphException(String message, Throwable cause) {
        super(message, cause);
    }
}
