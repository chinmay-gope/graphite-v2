package io.graphite.builder;

import io.graphite.generator.RandomGraphBuilder;
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
        return new GraphTransformFactory();
    }

    public static PatternGraphFactory patterns() {
        return new PatternGraphFactory();
    }

    public static GraphReaderService read() {
        return new GraphReaderService();
    }

}
