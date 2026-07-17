package io.graphite.generator;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.GraphConfiguration;
import io.graphite.builder.Graphs;
import io.graphite.generator.internal.EdgeTracker;
import io.graphite.generator.validation.RandomGraphValidator;
import io.graphite.graph.IGraph;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility for generating random graphs using a fluent builder API.
 * <p>
 * Supports:
 * <ul>
 *   <li>Directed and undirected graphs</li>
 *   <li>Weighted and unweighted edges</li>
 *   <li>Connected graph generation</li>
 *   <li>Self-loops</li>
 *   <li>Parallel edges</li>
 * </ul>
 */
public final class RandomGraphGenerator {

    private final GraphConfiguration configuration;
    private final EdgeTracker tracker;

    private RandomGraphGenerator(GraphConfiguration configuration,
                                 EdgeTracker tracker) {
        this.configuration = configuration;
        this.tracker = tracker;
    }

    private boolean isSelfLoop(int source, int destination) {
        return source == destination;
    }

    private ThreadLocalRandom random() {
        return ThreadLocalRandom.current();
    }

    private int randomVertex() {
        return random().nextInt(configuration.getVertices());
    }

    private int randomWeight() {
        return random().nextInt(configuration.getMinWeight(), configuration.getMaxWeight() + 1);
    }

    private void addEdge(AbstractGraphBuilder<?, ?> builder, int source, int destination) {
        int weight = randomWeight();

        if (configuration.isWeighted()) {
            builder.addEdge(source, destination, weight);
        } else {
            builder.addEdge(source, destination);
        }

        tracker.remember(source, destination);
    }

    private void generateRemainingEdges(AbstractGraphBuilder<?, ?> builder) {
        while (tracker.size() < configuration.getEdges()) {
            int source = randomVertex();
            int destination = randomVertex();
            if (!configuration.allowsSelfLoops() && isSelfLoop(source, destination)) {
                continue;
            }
            if (!(configuration.allowParallelEdges()) && tracker.contains(source, destination)) {
                continue;
            }
            addEdge(builder, source, destination);
        }
    }

    private void generateSpanningTree(AbstractGraphBuilder<?, ?> builder) {
        for (int vertex = 1; vertex < configuration.getVertices(); vertex++) {
            int parent = random().nextInt(vertex);
            addEdge(builder, parent, vertex);
        }
    }

    private AbstractGraphBuilder<?, ?> createBuilder() {

        return configuration.isDirected() ? Graphs.directed().vertices(configuration.getVertices()).weighted(configuration.isWeighted()) : Graphs.undirected().vertices(configuration.getVertices()).weighted(configuration.isWeighted());
    }

    public IGraph generate() {

        RandomGraphValidator.validate(configuration);

        AbstractGraphBuilder<?, ?> builder = createBuilder();

        EdgeTracker tracker =
                new EdgeTracker(configuration);


        if (configuration.isConnected()) {
//            generator.generateSpanningTree(builder);
        }

//        generator.generateRemainingEdges(builder);

        return builder.build();
    }
}
