package main.java.io.graphite.benchmark;

public record BenchmarkConfig(int warmup, int iterations, boolean measureMemory) {
    public static BenchmarkConfig defaults() {
        return new BenchmarkConfig(5, 20, false);
    }
}
