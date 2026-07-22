package io.graphite.generator.internal;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.GraphConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public final class SpanningTreeGenerator {

    private SpanningTreeGenerator() {
    }

    public static void generate(AbstractGraphBuilder<?, ?> builder,
                                GraphConfiguration configuration,
                                EdgeTracker tracker) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int vertex = 1; vertex < configuration.getVertices(); vertex++) {
            int parent = random.nextInt(vertex);

            if (configuration.isWeighted()) {
                builder.addEdge(
                        parent,
                        vertex,
                        RandomWeightGenerator.next(configuration)
                );
            } else {
                builder.addEdge(parent, vertex);
            }

            tracker.remember(parent, vertex);
        }
    }
}
