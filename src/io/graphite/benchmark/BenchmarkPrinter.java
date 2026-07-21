package io.graphite.benchmark;

import io.graphite.result.BenchmarkResult;

import static io.graphite.result.Colors.*;

public final class BenchmarkPrinter {

    private BenchmarkPrinter() {
    }

    public static void print(BenchmarkResult result) {
        System.out.println();
        System.out.println(BOLD + CYAN + "▶ " + result.name() + RESET);

        System.out.printf("%-20s : %s%d%s%n", "Warmup", YELLOW, result.warmup(), RESET);
        System.out.printf("%-20s : %s%d%s%n", "Iterations", YELLOW, result.iterations(), RESET);

        System.out.printf("%-20s : %s%.3f ms%s%n", "Average", CYAN, result.averageMillis(), RESET);
        System.out.printf("%-20s : %s%.3f ms%s%n", "Minimum", GREEN, result.minimumMillis(), RESET);
        System.out.printf("%-20s : %s%.3f ms%s%n", "Maximum", RED, result.maximumMillis(), RESET);

        System.out.printf("%-20s : %s%.3f ms%s%n", "Std Deviation", MAGENTA, result.standardDeviation(), RESET);
        System.out.printf("%-20s : %s%.2f ops/sec%s%n", "Ops/sec", BLUE, result.operationsPerSecond(), RESET);
    }
}
