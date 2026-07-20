package io.graphite.generator.example;

public class GraphExampleFactory {

    public static final GraphExampleFactory INSTANCE = new GraphExampleFactory();

    private GraphExampleFactory() {

    }

    public GraphExampleFactory examples() {
        return new GraphExampleFactory();
    }
}
