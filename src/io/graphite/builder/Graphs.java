package io.graphite.builder;

import io.graphite.generator.RandomGraphBuilder;
import io.graphite.generator.example.GraphExampleGenerator;
import io.graphite.generator.preset.GraphPresetGenerator;
import io.graphite.graph.PatternGraphFactory;
import io.graphite.graph.transform.GraphTransformFactory;
import io.graphite.io.reader.GraphReaderService;

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
