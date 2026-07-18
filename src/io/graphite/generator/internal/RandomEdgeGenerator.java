package io.graphite.generator.internal;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.GraphConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomEdgeGenerator {

    private RandomEdgeGenerator() {
        throw new AssertionError("Utility class");
    }

    public static void generate(
            AbstractGraphBuilder<?, ?> builder,
            GraphConfiguration configuration,
            EdgeTracker tracker) {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        while (tracker.size() < configuration.getEdges()) {

            int source = random.nextInt(configuration.getVertices());
            int destination = random.nextInt(configuration.getVertices());

            if (!configuration.allowsSelfLoops()
                    && source == destination) {
                continue;
            }

            if (!configuration.allowParallelEdges()
                    && tracker.contains(source, destination)) {
                continue;
            }

            if (configuration.isWeighted()) {

                builder.addEdge(
                        source,
                        destination,
                        RandomWeightGenerator.next(configuration));

            } else {

                builder.addEdge(source, destination);
            }

            tracker.remember(source, destination);
        }
    }
}
