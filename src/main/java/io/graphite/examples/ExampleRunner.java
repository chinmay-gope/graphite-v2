package main.java.io.graphite.examples;

import main.java.graphite.examples.algorithm.*;
import main.java.io.graphite.examples.algorithm.*;
import main.java.io.graphite.examples.core.BasicExamples;
import main.java.io.graphite.examples.core.BuilderExamples;
import main.java.io.graphite.examples.core.GeneratorExamples;
import main.java.io.graphite.examples.format.FormatterExamples;
import main.java.io.graphite.examples.io.GraphIOExamples;
import main.java.io.graphite.examples.performance.BenchmarkExamples;
import main.java.io.graphite.examples.performance.StressExamples;

import java.io.IOException;

public final class ExampleRunner {

    private ExampleRunner() {
    }

    static void main(String[] args) throws IOException {

        TraversalExamples.run();
        BasicExamples.run();
        BuilderExamples.run();
        GeneratorExamples.run();
        CycleExamples.run();
        ShortestPathExamples.run();
        MSTExamples.run();
        ConnectivityExamples.run();
        TopologyExamples.run();
        BipartiteExamples.run();
        EulerExamples.run();
        FormatterExamples.run();
        BenchmarkExamples.run();
        StressExamples.run();

        GraphIOExamples.run();

    }
}
