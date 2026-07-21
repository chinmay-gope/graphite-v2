package io.graphite.examples;

import io.graphite.examples.algorithm.*;
import io.graphite.examples.core.BasicExamples;
import io.graphite.examples.core.BuilderExamples;
import io.graphite.examples.core.GeneratorExamples;
import io.graphite.examples.format.FormatterExamples;
import io.graphite.examples.performance.BenchmarkExamples;
import io.graphite.examples.performance.StressExamples;

public final class ExampleRunner {

    private ExampleRunner() {
    }

    static void main(String[] args) {

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

    }
}
