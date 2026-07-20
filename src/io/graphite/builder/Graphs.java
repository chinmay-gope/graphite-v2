package io.graphite.builder;

import io.graphite.generator.RandomGraphBuilder;
import io.graphite.generator.example.GraphExampleFactory;
import io.graphite.generator.preset.GraphPresetFactory;
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

    public static GraphPresetFactory presets() {

        return GraphPresetFactory.INSTANCE;
    }

    public static GraphExampleFactory examples() {

        return GraphExampleFactory.INSTANCE;
    }


    public static PatternGraphFactory patterns() {
        return PatternGraphFactory.INSTANCE;
    }

    public static GraphReaderService read() {
        return GraphReaderService.INSTANCE;
    }

}
