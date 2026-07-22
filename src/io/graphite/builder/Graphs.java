package io.graphite.builder;

import io.graphite.generator.RandomGraphBuilder;
import io.graphite.generator.example.GraphExampleGenerator;
import io.graphite.generator.preset.GraphPresetGenerator;
import io.graphite.graph.PatternGraphFactory;
import io.graphite.graph.transform.GraphTransformFactory;
import io.graphite.io.reader.GraphReaderService;


/**
 * Entry point for constructing, generating, and obtaining graph instances.
 *
 * <p>{@code Graphs} provides a collection of static factory methods that
 * expose Graphite's builder and generator framework through a unified API.</p>
 *
 * <pre>{@code
 * Graphs.undirected();
 *
 * Graphs.directed();
 *
 * Graphs.random();
 *
 * Graphs.patterns();
 *
 * Graphs.presets();
 *
 * Graphs.examples();
 * }</pre>
 *
 * <p>This class should be the preferred starting point for creating graphs.
 * Users are encouraged to use these factory methods instead of directly
 * instantiating graph implementations.</p>
 *
 * @since 2.0
 */
public final class Graphs {

    private Graphs() {
    }

    // Builders
    public static DirectedGraphBuilder directed() {
        return new DirectedGraphBuilder();
    }

    public static UndirectedGraphBuilder undirected() {
        return new UndirectedGraphBuilder();
    }

    public static RandomGraphBuilder random() {
        return new RandomGraphBuilder();
    }

    public static GraphTransformFactory transform() {
        return GraphTransformFactory.INSTANCE;
    }

    public static GraphPresetGenerator presets() {

        return GraphPresetGenerator.INSTANCE;
    }

    public static GraphExampleGenerator examples() {

        return GraphExampleGenerator.INSTANCE;
    }

    public static PatternGraphFactory patterns() {
        return PatternGraphFactory.INSTANCE;
    }

    public static GraphReaderService read() {
        return GraphReaderService.INSTANCE;
    }

}
