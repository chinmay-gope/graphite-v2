package io.graphite.algorithm.builder;

public final class BuilderValidator {
    private BuilderValidator() {
        throw new AssertionError("Utility class");
    }

    public static void validate(GraphConfiguration configuration) {
        if (configuration.getVertices() <= 0) {
            throw new IllegalArgumentException("Vertices must be greater than 0");
        }

        if (configuration.getMinWeight() > configuration.getMaxWeight()) {
            throw new IllegalArgumentException("Min Weight cannot exceed Max Weight.");
        }
    }
}
