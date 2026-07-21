package io.graphite.result;

import static io.graphite.result.Colors.*;

public record BenchmarkResult(
        String name,
        int warmup,
        int iterations,
        double totalMillis,
        double averageMillis,
        double minimumMillis,
        double maximumMillis,
        double standardDeviation,
        double operationsPerSecond
) {
    @Override
    public String toString() {

        return BOLD + CYAN +
                "══════════════════════════════════════════════\n" +
                "              BENCHMARK RESULT\n" +
                "══════════════════════════════════════════════\n" +
                RESET +
                BOLD + "Name: " + RESET +
                GREEN + name + RESET + "\n\n" +
                BOLD + "Warmup: " + RESET +
                YELLOW + warmup + RESET + "\n" +
                BOLD + "Iterations: " + RESET +
                YELLOW + iterations + RESET + "\n\n" +
                BOLD + "Total Time (ms): " + RESET +
                CYAN + String.format("%.2f", totalMillis) + RESET + "\n" +
                BOLD + "Average Time (ms): " + RESET +
                CYAN + String.format("%.2f", averageMillis) + RESET + "\n" +
                BOLD + "Minimum Time (ms): " + RESET +
                GREEN + String.format("%.2f", minimumMillis) + RESET + "\n" +
                BOLD + "Maximum Time (ms): " + RESET +
                RED + String.format("%.2f", maximumMillis) + RESET + "\n" +
                BOLD + "Std. Deviation: " + RESET +
                MAGENTA + String.format("%.2f", standardDeviation) + RESET + "\n" +
                BOLD + "Ops/sec: " + RESET +
                BLUE + String.format("%.2f", operationsPerSecond) + RESET + "\n" +
                BOLD + CYAN +
                "══════════════════════════════════════════════\n" +
                RESET;
    }
}
