package io.graphite.generator.internal;

import io.graphite.builder.GraphConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomWeightGenerator {

    private RandomWeightGenerator() {
    }

    public static int next(GraphConfiguration configuration) {

        return ThreadLocalRandom.current().nextInt(
                configuration.getMinWeight(),
                configuration.getMaxWeight() + 1
        );
    }
}
