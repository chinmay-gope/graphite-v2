package io.graphite.algorithm.benchmark;

import io.graphite.algorithm.examples.util.DemoUtils;
import io.graphite.graph.Graph;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;

public final class StressRunner {

    private StressRunner() {
    }

    public static void run(
            String title,
            StressConfig config,
            Function<Integer, Graph> graphFactory,
            Consumer<Graph> algorithm) {

        DemoUtils.run(title, () -> {
            long total = 0;

            for (int vertices : config.vertices()) {

                long start = System.nanoTime();

                for (int i = 0; i < config.iterations(); i++) {

                    Graph graph = graphFactory.apply(vertices);

                    algorithm.accept(graph);
                }

                long end = System.nanoTime();

                total += end - start;

                System.out.printf(
                        "✓ %-5d vertices (%d graphs)%n",
                        vertices,
                        config.iterations()
                );
            }

            System.out.printf(
                    "%nTotal Time : %.3f ms%n",
                    total / 1_000_000.0
            );
        });
    }

    public static int randomSource(Graph graph) {

        return ThreadLocalRandom.current().nextInt(graph.getVertices());
    }
}
