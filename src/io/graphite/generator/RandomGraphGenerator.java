package io.graphite.generator;

import io.graphite.builder.AbstractGraphBuilder;
import io.graphite.builder.GraphConfiguration;
import io.graphite.builder.Graphs;
import io.graphite.generator.internal.EdgeTracker;
import io.graphite.generator.internal.RandomEdgeGenerator;
import io.graphite.generator.internal.RandomWeightGenerator;
import io.graphite.generator.internal.SpanningTreeGenerator;
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

    private RandomGraphGenerator(GraphConfiguration configuration, EdgeTracker tracker) {
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

    private void addEdge(AbstractGraphBuilder<?, ?> builder, int source, int destination) {
        int weight = RandomWeightGenerator.next(configuration);

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

    private AbstractGraphBuilder<?, ?> createBuilder() {

        return configuration.isDirected() ?
                Graphs.directed().vertices(configuration.getVertices()).weighted(configuration.isWeighted())
                : Graphs.undirected().vertices(configuration.getVertices()).weighted(configuration.isWeighted());
    }

    public IGraph generate() {

        RandomGraphValidator.validate(configuration);

        AbstractGraphBuilder<?, ?> builder = createBuilder();

        EdgeTracker tracker = new EdgeTracker(configuration);


        if (configuration.isConnected()) {

            configuration.setVertices(configuration.getVertices());
            configuration.setWeighted(configuration.isWeighted());
            configuration.setConnected(true);

            SpanningTreeGenerator.generate(
                    builder,
                    configuration,
                    tracker);
        }

        RandomEdgeGenerator.generate(
                builder,
                configuration,
                tracker);

        return builder.build();
    }
}
